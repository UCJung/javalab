package com.mykumi.crawler4j.parser;

import java.net.MalformedURLException;
import java.util.Map;

import org.jsoup.select.Elements;

public class ProductParser11 extends ProductParser {

	public ProductParser11(String html, String url) throws MalformedURLException {
		super(html, url);
	}

	@Override
	public boolean parseBasicInfo() {
		Map<String, String> mapQueryParams = parseQueryString(url);
		
		product.setProductNumber(mapQueryParams.get("prdNo"))
				.setCategoryNumber(mapQueryParams.get("trCtgrNo"))
				.setProductName(doc.select(".prdc_heading_v2 h2").html());

		String productImage = doc.select("#thumb img").first().attr("src");
		String sellPrice = doc.select("#selPrcArea em").first().html();
		String discountPrice = doc.select("#dscSelPrcArea em").first().html();
		Elements eleOptions = doc.select("#cbxOptSel1 option");
		String optionName = doc.select("#trSelectOptArea label").first().html();		

		return false;
	}

	@Override
	public boolean parseDetailInfo() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean parseOptionInfo() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean parseContentInfo() {
		// TODO Auto-generated method stub
		return false;
	}

}
