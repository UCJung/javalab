package com.mykumi.designpattern.chainofresponsibility;

public class BenefitPointApplication extends BenefitApplication {

	@Override
	public void applyBenefit() {
		System.out.println("Point 적용");
	}

}
