package com.mykumi.designpattern.chainofresponsibility;

import java.util.ArrayList;

public class BenefitClient {
	private static ArrayList<Benefit> benefits = new ArrayList<Benefit>();
	
	public static void main(String[] args) {
		createBenefits();
		BenefitApplicationFactory.getBenefitApplicationResponsbleChain().excute(benefits);	
	}

	private static void createBenefits() {
		benefits.add(new Benefit(BenefitType.Coupon, "A Coupon"));
		benefits.add(new Benefit(BenefitType.Point, "A Point"));
		benefits.add(new Benefit(BenefitType.Coupon, "B Coupon"));
		benefits.add(new Benefit(BenefitType.Discount, "A Discont"));
		benefits.add(new Benefit(BenefitType.Discount, "B Discont"));
		benefits.add(new Benefit(BenefitType.Point, "B Point"));
	}
}
