package com.mykumi.designpattern.chainofresponsibility;

public class BenefitPointApplication extends BenefitApplication {

	@Override
	public void applyBenefit() {
		if (sourceBenefit.getBenefitType() == BenefitType.Point)
			System.out.println(sourceBenefit.getBenefitName() + ": Point 적용");
	}

}
