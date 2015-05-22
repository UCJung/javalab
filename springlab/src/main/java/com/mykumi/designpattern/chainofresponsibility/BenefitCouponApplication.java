package com.mykumi.designpattern.chainofresponsibility;

public class BenefitCouponApplication extends BenefitApplication {

	@Override
	public void applyBenefit() {
		if (sourceBenefit.getBenefitType() == BenefitType.Coupon)
			System.out.println(sourceBenefit.getBenefitName() + ": Coupon 적용");
	}

}
