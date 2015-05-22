package com.mykumi.designpattern.chainofresponsibility;

public enum BenefitType {
	Point(0), Discount(1), Coupon(2);
	
	private int value;
	
	private BenefitType(int value) {
		this.value = value;
	}
	
	public int getValue() {
		return this.value;
	}
}
