package com.mykumi.designpattern.chainofresponsibility;

public class BenefitApplicationFactory {
	public static BenefitApplication getBenefitApplication(BenefitType benefitType) {
		BenefitApplication ba = null;

		switch (benefitType) {
		case  Point :
			ba = new BenefitPointApplication();
			break;
		case  Coupon :
			ba = new BenefitCouponApplication();
			break;
		case  Discount :
			ba = new BenefitDiscountApplication();
			break;
		default:
			break;		
		}
		
		return ba;
	}
}
