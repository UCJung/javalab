package com.mykumi.crawler4j.amazon;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.xml.sax.SAXException;

import am.ik.aws.apa.AwsApaRequester;
import am.ik.aws.apa.AwsApaRequesterImpl;
import am.ik.aws.apa.jaxws.Item;
import am.ik.aws.apa.jaxws.ItemSearchRequest;
import am.ik.aws.apa.jaxws.ItemSearchResponse;
import am.ik.aws.apa.jaxws.Items;

public abstract class amazonClient {
	private static final String AWS_ACCESS_KEY_ID = "AKIAICYS3C4RAXGCLPHA";
    private static final String AWS_SECRET_KEY = "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";
    private static final String ASSOCIATE_TAG = "mykumi-20";
    private static final String ENDPOINT = "ecs.amazonaws.com";
    protected Map<String, String> params = new HashMap<String, String>();
    
    protected Document doc;
    
    private String requestUrl;
    
    public void setParams(String keyWord) {
    	params.put("AssociateTag",ASSOCIATE_TAG);
    	params.put("Service", "AWSECommerceService");
        params.put("Version", "2009-03-31");
        params.put("Operation", "ItemSearch");
        params.put("Availability", "Available");
        params.put("SearchIndex", "All");
        params.put("ResponseGroup", "Small,Images,ItemAttributes,OfferFull");
        params.put("ItemPage", "1");
        params.put("Keywords", keyWord);
    }
    
    public Document request() {
    	DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
    	DocumentBuilder db;
		try {
			db = dbf.newDocumentBuilder();
			doc = db.parse(requestUrl);
			return doc;
		} catch (ParserConfigurationException e) {
			throw new RuntimeException(e);
		} catch (SAXException e) {
			throw new RuntimeException(e);
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
    }
}
