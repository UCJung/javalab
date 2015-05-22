package com.mykumi.designpattern.chainofresponsibility;

public class BenefitApplication {
	private Benefit sourceBenefit;
	
	public void setBenefit(Benefit benefit) {
		this.sourceBenefit = benefit;
	} 
	
	public void applyBenefit() {
		switch (this.sourceBenefit.getBenefitType()) {
			case  Point :
				System.out.println("Point 적용");
				break;
			case  Coupon :
				System.out.println("Coupon 적용");
				break;
			case  Discount :
				System.out.println("Discount 적용");
				break;				
			default:
				break;
		}
	}
}
