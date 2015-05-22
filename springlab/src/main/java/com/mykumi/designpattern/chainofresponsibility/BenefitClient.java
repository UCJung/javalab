package com.mykumi.designpattern.chainofresponsibility;

import java.util.ArrayList;

public class BenefitClient {
	public static void main(String[] args) {
		ArrayList<Benefit> benefits = new ArrayList<Benefit>();

		benefits.add(new Benefit(BenefitType.Coupon, "A Coupon"));
		benefits.add(new Benefit(BenefitType.Point, "A Point"));
		benefits.add(new Benefit(BenefitType.Discount, "A Discont"));
		
		applyBenefit(benefits);
	}

	private static void applyBenefit(ArrayList<Benefit> benefits) {
		BenefitApplication ba = new BenefitApplication();
		
		for (Benefit benefit : benefits) {
			ba.setBenefit(benefit);
			ba.applyBenefit();			
		}
	}
}
