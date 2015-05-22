package com.mykumi.designpattern.chainofresponsibility;

public class BenefitDiscountApplication extends BenefitApplication {

	@Override
	public void applyBenefit() {
		System.out.println("Discount 적용");
	}

}
