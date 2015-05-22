package com.mykumi.designpattern.chainofresponsibility;

public abstract class BenefitApplication {
	protected Benefit sourceBenefit;
	
	public void setBenefit(Benefit benefit) {
		this.sourceBenefit = benefit;
	}
	
	public abstract void applyBenefit();
}
