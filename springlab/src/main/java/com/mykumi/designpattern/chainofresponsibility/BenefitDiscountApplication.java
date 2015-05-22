package com.mykumi.designpattern.chainofresponsibility;

public class BenefitDiscountApplication extends BenefitApplication {

	@Override
	public void applyBenefit() {
		if (sourceBenefit.getBenefitType() == BenefitType.Discount)
			System.out.println(sourceBenefit.getBenefitName() + ": Discount 적용");
	}

}
