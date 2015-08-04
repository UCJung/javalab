package com.mykumi.crawler4j.parser;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import com.mykumi.crawler4j.model.Product;

public abstract class ProductParser {
	protected String html;
	protected URL url;
	protected Document doc;
	protected Product product;
	protected Map<String, String> mapQueryParams;
	
	public ProductParser(String html, String url) throws MalformedURLException {
		this.html = html;
		this.doc = Jsoup.parse(html);
		this.url = new URL(url);
		this.mapQueryParams = parseQueryString(this.url);
	}
	
	public abstract boolean parseBasicInfo();
	public abstract boolean parseDetailInfo();
	public abstract boolean parseOptionInfo();
	public abstract boolean parseContentInfo();
	
	public Product parse() {
		if (product == null) {
			product = new Product();
		}
		this.parseBasicInfo();
		this.parseDetailInfo();
		this.parseOptionInfo();
		this.parseContentInfo();
		return this.product;
	}
	
	protected Map<String, String> parseQueryString(URL url) {
		Map<String, String> mapQueryParams = new HashMap<String, String>();
		
		String[] queryParams = url.getQuery().split("&");
		
		for (String string : queryParams) {
			String[] queryParam = string.split("=");
			mapQueryParams.put(queryParam[0], queryParam[1]);
		}
		return mapQueryParams;
	}	
}
