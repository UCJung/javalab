package com.mykumi.crawler4j.parser;

import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.List;

import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import com.mykumi.crawler4j.model.OptionItem;
import com.mykumi.crawler4j.model.ProductOption;

public class ProductParser11 extends ProductParser {

	public ProductParser11(String html, String url) throws MalformedURLException {
		super(html, url);
	}
	
	@Override
	public boolean parseBasicInfo() {
		product.setProductNumber(mapQueryParams.get("prdNo"))
				.setCategoryNumber((mapQueryParams.get("trCtgrNo") != null) ? mapQueryParams.get("trCtgrNo") : "")
				.setProductName(doc.select(".prdc_heading_v2 h2").html())
				.setSellPrice(doc.select("#selPrcArea em").first().html())
				.setDiscountPrice((doc.select("#dscSelPrcArea em").size() > 0) ? doc.select("#dscSelPrcArea em").first().html() : "")
				.setProductImage(doc.select("#thumb img").first().attr("src"));

		return false;
	}

	@Override
	public boolean parseDetailInfo() {
		// 상품정보
		Elements eleInfoTitles = doc.select("#productInfo .prdc_detail_table th");
		Elements eleInfoValues = doc.select("#productInfo .prdc_detail_table td");
		
		List<String> productDetailInfo = new ArrayList<String>();
		for (int i = 0 ; i < eleInfoTitles.size() ; i ++) {
			product.addDetailInfo(eleInfoTitles.get(i).html(), eleInfoValues.get(i).html());
		}
		
		return false;
	}

	@Override
	public boolean parseOptionInfo() {
		
		Elements optionLabels = doc.select("#trSelectOptArea label");
		
		for ( int i = 0 ; i < optionLabels.size() ; i ++ ) {
			ProductOption productOption = new ProductOption();
			productOption.setOptionText(optionLabels.get(i).html());
			
			Elements eleOptions = doc.select("#cbxOptSel" + (i+1) + " option");
			List<String> options = new ArrayList<String>();
			for (Element element : eleOptions) {
				if (element.val().isEmpty()) continue;
				OptionItem optionItem = new OptionItem();
				
				optionItem.setOptionValue(element.val());
				optionItem.setOptionText(element.html());
				
				productOption.addOptionItem(optionItem);
			}		
			product.addOption(productOption);
		}
		
		return false;
	}

	@Override
	public boolean parseContentInfo() {
		// TODO Auto-generated method stub
		return false;
	}

}
