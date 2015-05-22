package com.mykumi.designpattern.chainofresponsibility;

public class Benefit {
	private BenefitType benefitType;
	private String benefitName;
	
	public Benefit(BenefitType benefitType, String benefitName) {
		this.setBenefitType(benefitType);
		this.setBenefitName(benefitName);
	}

	public BenefitType getBenefitType() {
		return benefitType;
	}

	public void setBenefitType(BenefitType benefitType) {
		this.benefitType = benefitType;
	}

	public String getBenefitName() {
		return benefitName;
	}

	public void setBenefitName(String benefitName) {
		this.benefitName = benefitName;
	}
}
