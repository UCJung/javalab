package com.mykumi.atpuzzle.blockmodel;

public enum AttackType {
	Vertical(0), Horizontal(1), Cross(2), Scope(3);
	
	private int value;
	
	private AttackType(int value) {
		this.value = value;
	}
	
	public int getValue() {
		return this.value;
	}
	
   public static AttackType fromValue(int value) {
	   return AttackType.values()[value];
   }	
}
