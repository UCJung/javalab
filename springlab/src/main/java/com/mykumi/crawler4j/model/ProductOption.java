package com.mykumi.crawler4j.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ProductOption {
	private String optionText;
	private List<OptionItem> optionItems;
	
	public List<OptionItem> getOptionItems() {
		return optionItems;
	}
	public void setOptionItems(List<OptionItem> optionItems) {
		this.optionItems = optionItems;
	}
	public String getOptionText() {
		return optionText;
	}
	public void setOptionText(String optionText) {
		this.optionText = optionText;
	}
	public void addOptionItem(OptionItem optionItem) {
		if ( optionItems == null ) {
			optionItems = new ArrayList<OptionItem>();
		}
		optionItems.add(optionItem);
	}
	
}
