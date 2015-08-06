package com.mykumi.crawler4j;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import com.mykumi.crawler4j.parser.ParseStrategy;


public class ParseWebPage {
	private URL url;
	private ParseStrategy stg;
	
	public ParseWebPage(String url) throws MalformedURLException {
		this.url = new URL(url);
		this.stg = new ParseStrategy() {
			
			@Override
			public String parsePage(Document page) {
				return null;
			}
		};
	}
	
	public String getWebInfomation(ParseStrategy stg) throws IOException {
		if (stg != null) {
			this.stg = stg;
		}
		// 웹 요청을 통하여 페이지 정보 획득
		Document doc = Jsoup.parse(url, 3000);
		String resultJsonText = this.stg.parsePage(doc);
		
		System.out.println(resultJsonText);

		// 파싱을 통하여 
		return resultJsonText;
	}

	public void setParseStrategy(ParseStrategy stg) {
		this.stg = stg;
	}
	
}
