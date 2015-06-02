package com.mykumi.designpattern.chainofresponsibility;

import java.util.ArrayList;

public abstract class BenefitApplication {
	protected BenefitApplication nextApplicator;
	
	public BenefitApplication setNextApplicator(BenefitApplication nextApplicator) {
		this.nextApplicator = nextApplicator;
		return this.nextApplicator;
	}
	
	public abstract void applyBenefit(Benefit benefit);
	
	public void excute(Benefit benefit) {
		this.applyBenefit(benefit);
		if (nextApplicator != null) {
			nextApplicator.excute(benefit);
		}
	}
	
	public void excute(ArrayList<Benefit> benefits) {
		for (Benefit benefit : benefits) {
			this.applyBenefit(benefit);
		}
		if (nextApplicator != null) {
			nextApplicator.excute(benefits);
		}
	}	
}
