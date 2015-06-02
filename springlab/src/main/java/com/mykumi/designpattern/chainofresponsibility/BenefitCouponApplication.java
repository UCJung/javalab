package com.mykumi.designpattern.chainofresponsibility;

public class BenefitCouponApplication extends BenefitApplication {

	@Override
	public void applyBenefit(Benefit benefit) {
		if (benefit.getBenefitType() == BenefitType.Coupon)
			System.out.println(benefit.getBenefitName() + ": Coupon 적용");
	}

}
