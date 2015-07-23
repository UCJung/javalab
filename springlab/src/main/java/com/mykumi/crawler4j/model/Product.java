package com.mykumi.crawler4j.model;

import java.util.List;

public class Product {
	private String productNumber;
	private String categoryNumber;
	private String productName;
	private String productImage;
	private String sellPrice;
	private String discountPrice;
	private List<ProductOption> options;
	private List<ProductImage> images;
	private List<ProductDetail> detailInfo;
	
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
	public String getSellPrice() {
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
	public List<ProductDetail> getDetailInfo() {
		return detailInfo;
	}
	public Product setDetailInfo(List<ProductDetail> detailInfo) {
		this.detailInfo = detailInfo;
		return this;
	}
	public String getCategoryNumber() {
		return categoryNumber;
	}
	public Product setCategoryNumber(String categoryNumber) {
		this.categoryNumber = categoryNumber;
		return this;
	}
}
