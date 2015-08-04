package com.mykumi.crawler4j;

import java.net.URL;
import java.util.HashMap;
import java.util.Map;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import com.mykumi.crawler4j.model.Product;
import com.mykumi.crawler4j.parser.ProductParser;
import com.mykumi.crawler4j.parser.ProductParser11;
import com.mykumi.util.JsonUtil;

public class ParseHtml {
	@SuppressWarnings("unused")
	public static void main(String[] args) throws Exception {
		URL url = new URL("http://www.11st.co.kr/product/SellerProductDetail.tmall?method=getSellerProductDetail&prdNo=39006799&trCtgrNo=946854&trTypeCd=20");
		
		Document doc = Jsoup.parse(url, 5000);

		ProductParser productParser = new ProductParser11(doc.html(), url.toString()); 
		Product product = productParser.parse();
		
		System.out.println(JsonUtil.marshallingJson(product));
	}
}
