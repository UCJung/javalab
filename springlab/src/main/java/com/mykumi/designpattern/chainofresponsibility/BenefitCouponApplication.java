package com.mykumi.designpattern.chainofresponsibility;

public class BenefitCouponApplication extends BenefitApplication {

	@Override
	public void applyBenefit() {
		System.out.println("Coupon 적용");
	}

}
