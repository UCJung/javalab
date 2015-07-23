package com.mykumi.crawler4j.model;

public enum ImageType {
	Representation(1), Content(2);
	private int value;
	private ImageType(int value) {
		this.value = value;
	}
	public int getValue() {
		return this.value;
	}
}
