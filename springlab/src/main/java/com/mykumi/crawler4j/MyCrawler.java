package com.mykumi.crawler4j;

import java.net.MalformedURLException;
import java.util.Set;
import java.util.regex.Pattern;

import com.mykumi.crawler4j.model.Product;
import com.mykumi.crawler4j.parser.ProductParser;
import com.mykumi.crawler4j.parser.ProductParser11;
import com.mykumi.util.JsonUtil;

import edu.uci.ics.crawler4j.crawler.Page;
import edu.uci.ics.crawler4j.crawler.WebCrawler;
import edu.uci.ics.crawler4j.parser.HtmlParseData;
import edu.uci.ics.crawler4j.url.WebURL;

public class MyCrawler extends WebCrawler {
	private final static Pattern FILTERS = Pattern.compile(".*(\\.(html|tmall))+.+");
	private final static Pattern ProductFilters = Pattern.compile(".+(sellerproductdetail\\.(tmall\\?))+.+");
	
	@Override
	public boolean shouldVisit(Page page, WebURL url) {
		String href = url.getURL().toLowerCase();
		boolean result = FILTERS.matcher(href).matches() && href.startsWith("http://www.11st.co.kr");
		//System.out.println("URL: " + url + "result : " + result);
		return result;
	}
	
	@Override
	public void visit(Page page) {
		String url = page.getWebURL().getURL().toLowerCase();
		
		if (ProductFilters.matcher(url).matches()) {
			if (page.getParseData() instanceof HtmlParseData) {
				HtmlParseData htmlParseData = (HtmlParseData) page.getParseData();
				ProductParser productParser = null;
				try {
					productParser = new ProductParser11(htmlParseData.getHtml(), url);
				} catch (MalformedURLException e) {
					// TODO Auto-generated catch block
					System.out.println("ERROR : " + url);
					e.printStackTrace();
				} 
				Product product = productParser.parse();
				try {
					System.out.println(JsonUtil.marshallingJson(product));
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}			
			}
		} else {
			if (page.getParseData() instanceof HtmlParseData) {
				/*
				HtmlParseData htmlParseData = (HtmlParseData) page.getParseData();
				String text = htmlParseData.getText();
				String html = htmlParseData.getHtml();
				Set<WebURL> links = htmlParseData.getOutgoingUrls();
				
	            System.out.println("Text length: " + text.length());
	            System.out.println("Html length: " + html.length());
	            System.out.println("Number of outgoing links: " + links.size());		
	            */	
			}			
		}
	}
	
}
