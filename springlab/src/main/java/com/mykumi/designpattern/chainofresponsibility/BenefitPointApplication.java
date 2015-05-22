package com.mykumi.designpattern.chainofresponsibility;

public class BenefitPointApplication extends BenefitApplication {

	@Override
	public void applyBenefit(Benefit benefit) {
		if (benefit.getBenefitType() == BenefitType.Point)
			System.out.println(benefit.getBenefitName() + ": Point 적용");
	}

}
