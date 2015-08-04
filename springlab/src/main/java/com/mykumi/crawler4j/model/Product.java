package com.mykumi.crawler4j.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Product {
	private String productNumber;
	private String categoryNumber;
	private String productName;
	private String productImage;
	private float sellPrice;
	private float discountPrice;
	private List<ProductOption> options;
	private List<ProductImage> images;
	private Map<String, String> detailInfos;
	
	public String getProductName() {
		return productName;
	}
	public Product setProductName(String productName) {
		this.productName = productName;
		return this;
	}
	public String getProductNumber() {
		return productNumber;
	}
	public Product setProductNumber(String productNumber) {
		this.productNumber = productNumber;
		return this;
	}
	public String getProductImage() {
		return productImage;
	}
	public Product setProductImage(String productImage) {
		this.productImage = productImage;
		return this;
	}
	public float getSellPrice() {
		return sellPrice;
	}
	public Product setSellPrice(String sellPrice) {
		this.sellPrice = sellPrice;
		return this;
	}
	public String getDiscountPrice() {
		return discountPrice;
	}
	public Product setDiscountPrice(String discountPrice) {
		this.discountPrice = discountPrice;
		return this;
	}
	public List<ProductOption> getOptions() {
		return options;
	}
	public Product setOptions(List<ProductOption> options) {
		this.options = options;
		return this;
	}
	public List<ProductImage> getImages() {
		return images;
	}
	public Product setImages(List<ProductImage> images) {
		this.images = images;
		return this;
	}

	public String getCategoryNumber() {
		return categoryNumber;
	}
	public Product setCategoryNumber(String categoryNumber) {
		this.categoryNumber = categoryNumber;
		return this;
	}
	
	public Product addOption(ProductOption productOption) {
		if ( options == null ) {
			options = new ArrayList<ProductOption>();
		}
		options.add(productOption);
		return this;
	}
	
	public Product addDetailInfo(String key, String value) {
		if ( detailInfos == null ) {
			detailInfos = new HashMap<String, String>();
		}
		detailInfos.put(key, value);
		return this;
	}
}
