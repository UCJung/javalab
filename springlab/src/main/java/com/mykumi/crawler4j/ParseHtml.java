package com.mykumi.crawler4j;

import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class ParseHtml {
	@SuppressWarnings("unused")
	public static void main(String[] args) throws Exception {
		
		// URL Prasing 
		URL url = new URL("http://www.11st.co.kr/product/SellerProductDetail.tmall?method=getSellerProductDetail&prdNo=965306501&trCtgrNo=946845&trTypeCd=20");
		
		Map<String, String> mapQueryParams = parseQueryString(url);
		
		// get Query Parameter Data product number, Category Numve
		String productNumber = mapQueryParams.get("prdNo");
		String categoryNumber = mapQueryParams.get("trCtgrNo");
		
		Document doc = Jsoup.parse(url, 5000);
		
		Elements metas = doc.select("META");
		
		// 상품 기본 정보
		String productName = doc.select(".prdc_heading_v2 h2").html();
		String productImage = doc.select("#thumb img").first().attr("src");
		String sellPrice = doc.select("#selPrcArea em").first().html();
		String discountPrice = doc.select("#dscSelPrcArea em").first().html();
		Elements eleOptions = doc.select("#cbxOptSel1 option");
		String optionName = doc.select("#trSelectOptArea label").first().html();
		// 상품 옵션
		List<String> options = new ArrayList<String>();
		for (Element element : eleOptions) {
			if (element.val().isEmpty()) continue;
			options.add(element.html());
		}
		
		// 상품정보
		Elements eleInfoTitles = doc.select("#productInfo .prdc_detail_table th");
		Elements eleInfoValues = doc.select("#productInfo .prdc_detail_table td");
		
		List<String> productDetailInfo = new ArrayList<String>();
		for (int i = 0 ; i < eleInfoTitles.size() ; i ++) {
			productDetailInfo.add(eleInfoTitles.get(i).html() + " -- " + eleInfoValues.get(i).html());
		}

		System.out.println(productNumber);
		System.out.println(categoryNumber);
		System.out.println(productName);
		System.out.println(productImage);
		System.out.println(sellPrice + "/" + discountPrice);
		System.out.println(optionName);
		
		for (String string : options) {
			System.out.println(string);
		}
		
		for (String string : productDetailInfo) {
			System.out.println(string);
		}

	}

	private static Map<String, String> parseQueryString(URL url) {
		Map<String, String> mapQueryParams = new HashMap<String, String>();
		
		String[] queryParams = url.getQuery().split("&");
		
		for (String string : queryParams) {
			String[] queryParam = string.split("=");
			mapQueryParams.put(queryParam[0], queryParam[1]);
		}
		return mapQueryParams;
	}
}
