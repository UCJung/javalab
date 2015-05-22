package com.mykumi.designpattern.chainofresponsibility;

public class BenefitDiscountApplication extends BenefitApplication {

	@Override
	public void applyBenefit(Benefit benefit) {
		if (benefit.getBenefitType() == BenefitType.Discount)
			System.out.println(benefit.getBenefitName() + ": Discount 적용");
	}

}
