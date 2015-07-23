package com.mykumi.crawler4j.model;

public class ProductImage {
	private String url;
	private String UID;
	private ImageType imageType;
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getUID() {
		return UID;
	}
	public void setUID(String uID) {
		UID = uID;
	}
	public ImageType getImageType() {
		return imageType;
	}
	public void setImageType(ImageType imageType) {
		this.imageType = imageType;
	}
}
