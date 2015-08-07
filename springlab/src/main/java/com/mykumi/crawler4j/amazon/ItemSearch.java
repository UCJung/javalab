package com.mykumi.crawler4j.amazon;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.xml.parsers.*;

import org.w3c.dom.*;
import org.xml.sax.SAXException;

import com.mykumi.util.JsonUtil;

public class ItemSearch {
	private static final String AWS_ACCESS_KEY_ID = "AKIAICYS3C4RAXGCLPHA";
    private static final String AWS_SECRET_KEY = "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";
    private static final String ASSOCIATE_TAG = "mykumi-20";
    private static final String ENDPOINT = "ecs.amazonaws.com";
    
    public static final List<Map<String, String>> products = new ArrayList<Map<String,String>>();
	private static Map<String, String> requestParams;
	private static Document doc;

    public static void main(String[] args) {

    	setRequestParams();
    	System.out.println(parse(setRequestUrl()));
    }

	private static String setRequestUrl() {
		SignedRequestsHelper helper = creaeteRequestHelper();
        String requestUrl = helper.sign(requestParams);
		return requestUrl;
	}

	private static void setRequestParams() {
		requestParams = new HashMap<String, String>();
        requestParams.put("Service", "AWSECommerceService");
        requestParams.put("Version", "2009-03-31");
        requestParams.put("Operation", "ItemSearch");
        requestParams.put("Availability", "Available");
        requestParams.put("SearchIndex", "All");
        requestParams.put("ResponseGroup", "Small,Images,ItemAttributes,Offers");
        requestParams.put("ItemPage", "1");
        requestParams.put("Keywords", "iRobot Braava 320 Floor Mopping Robot");
        requestParams.put("AssociateTag",ASSOCIATE_TAG);
	}

	private static SignedRequestsHelper creaeteRequestHelper() {
		SignedRequestsHelper helper;
        try {
            helper = SignedRequestsHelper.getInstance(ENDPOINT, AWS_ACCESS_KEY_ID, AWS_SECRET_KEY);
        } catch (Exception e) {
        	throw new RuntimeException(e);
        }
		return helper;
	}

    private static String parse(String requestUrl) {
    	System.out.println(requestUrl);
		request(requestUrl);
		
		NodeList Items = doc.getElementsByTagName("Item");
		
		int itemCount = Items.getLength();
		
		for (int i = 0 ; i < itemCount ; i ++) {
			Map<String, String> product = new HashMap<String, String>();
		
			// 상품 URL
			Node item = Items.item(i);
			System.out.println(getNameNode(item, "DetailPageURL").getTextContent());
			product.put("url", getNameNode(item, "DetailPageURL").getTextContent());
			
			// 이미지 정보
			Node image = getNameNode(item, "MediumImage");
			if (image != null) {
				product.put("imageUrl", getNameNode(image, "URL").getTextContent());
			}
			
			// 상품정보
			Node itemAttributes = getNameNode(item, "ItemAttributes");
			if (itemAttributes != null) {
				product.put("productName", getNameNode(itemAttributes, "Title").getTextContent());
			}
			
			// 가격정보
			Node offers = getNameNode(item, "Offers");
			if (offers != null) {
				Node offerListing = getNameNode(offers, "OfferListing");
				if (offerListing == null) continue;
				Node price = getNameNode(offerListing, "Price");
				if ( price == null ) continue;
				product.put("currency", getNameNode(price, "CurrencyCode").getTextContent());
				product.put("priceSale", getNameNode(price, "FormattedPrice").getTextContent().replaceAll("[^0-9\\.]", ""));
				
				Node savePrice = getNameNode(offerListing, "AmountSaved");
				if (savePrice != null) {
					product.put("priceSave", getNameNode(savePrice, "FormattedPrice").getTextContent().replaceAll("[^0-9\\.]", ""));
					product.put("pricePub", String.valueOf((Float.valueOf(product.get("priceSale")) + Float.valueOf(product.get("priceSale")))));
				} else {
					product.put("pricePub", product.get("priceSale"));
				}
			}			
			products.add(product);
		}
		return JsonUtil.marshallingJson(products);
   }

	private static void request(String requestUrl) {
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		DocumentBuilder db;
		try {
			db = dbf.newDocumentBuilder();
			doc = db.parse(requestUrl);
		} catch (ParserConfigurationException | SAXException | IOException e) {
			throw new RuntimeException(e);
		}
	}

	private static Node getNameNode(Node parent, String searchTagName) {
		NodeList nodes = ((Element) parent).getElementsByTagName(searchTagName);
		return (nodes.getLength() > 0) ? nodes.item(0) : null ;
	}  
	
	private static NodeList getNameNodes(Node parent, String searchTagName) {
		NodeList nodes = ((Element) parent).getElementsByTagName(searchTagName);
		return nodes;
	}  
}