package com.mykumi.designpattern.chainofresponsibility;

public abstract class BenefitApplication {
	protected BenefitApplication nextApplicator;
	protected Benefit sourceBenefit;
	
	public BenefitApplication setNextApplicator(BenefitApplication nextApplicator) {
		this.nextApplicator = nextApplicator;
		return this.nextApplicator;
	}
	
	public void setBenefit(Benefit benefit) {
		this.sourceBenefit = benefit;
	}
	
	public abstract void applyBenefit();
	
	public void excute() {
		this.applyBenefit();
		if (nextApplicator != null) {
			nextApplicator.setBenefit(sourceBenefit);
			nextApplicator.excute();
		}
	}
}
