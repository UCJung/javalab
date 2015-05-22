package com.mykumi.designpattern.chainofresponsibility;

import java.util.ArrayList;

public class BenefitClient {
	private static BenefitApplication baChain = BenefitApplicationFactory.getBenefitApplicationResponsbleChain();;
	private static ArrayList<Benefit> benefits = new ArrayList<Benefit>();
	
	public static void main(String[] args) {
		createBenefits();
		applyBenefit();
	}

	private static void createBenefits() {
		benefits.add(new Benefit(BenefitType.Coupon, "A Coupon"));
		benefits.add(new Benefit(BenefitType.Point, "A Point"));
		benefits.add(new Benefit(BenefitType.Discount, "A Discont"));
	}

	private static void applyBenefit() {
		for (Benefit benefit : benefits) {
			baChain.setBenefit(benefit);
			baChain.excute();			
		}
	}
}
