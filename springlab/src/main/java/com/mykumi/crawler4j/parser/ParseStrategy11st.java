package com.mykumi.crawler4j.parser;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import com.mykumi.crawler4j.ParseWebPageTest;
import com.mykumi.util.JsonUtil;

public final class ParseStrategy11st implements ParseStrategy {

	@Override
	public String parsePage(Document page) {
		List<Map<String, String>> Products = new ArrayList<Map<String,String>>();
		
		Elements eleProducts = page.select("#product_listing > .type_listing > ul > li");
		
		for (Element eleProduct : eleProducts) {
			Map<String, String> product = new HashMap<String, String>();
			
			// Link 정보 생성
			Elements eleLinks = eleProduct.select(".photo_wrap a");
			if (eleLinks.size() == 0)  continue;
			product.put("url", eleLinks.first().attr("href"));
			
			// Image URL 정보 생성
			Elements eleImage = eleLinks.select("img");
			if (eleImage.size() == 0)  continue;
			product.put("imageUrl", eleImage.first().attr("src"));
			product.put("productName", eleImage.first().attr("alt"));
			
			Element pupInfo = eleProduct.select(".pup_info").first();
			
			// 해외배송여부
			Elements eleForegins =  pupInfo.select(".pup_title .foreign_dev");
			if ( eleForegins.size() > 0 ) {
				product.put("isForegin", "Y");
				product.put("foreginInfo", eleForegins.first().attr("title"));
			}
			
			// 가격
			Element priceInfo = eleProduct.select(".price_area").first();
			
			// 기존가격
			Elements elePubPrice = priceInfo.select(".pub_price");
			if (elePubPrice.size() > 0) {
				product.put("pricePub", elePubPrice.first().html().replaceAll("[^0-9\\.]", ""));
			}

			// 판매가격
			Elements eleSalePrice = priceInfo.select(".pub_salep span");
			if (eleSalePrice.size() > 0) {
				product.put("priceSale", eleSalePrice.first().html().replaceAll("[^0-9\\.]", ""));
			}			
			
			// 배송조건
			Elements eleDelivery = elePubPrice.select(".deliver_info");
			if (eleDelivery.size() > 0) {
				product.put("delivery", eleDelivery.first().text());
			}
			
			Products.add(product);
		}
		
		try {
			return JsonUtil.marshallingJson(Products);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "";
	}
}