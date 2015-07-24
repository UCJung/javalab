package com.mykumi.atpuzzle.blockmodel;

public enum BlockType {
	Empty(0), Defend(1), Attack(2), Item(3);
	
	private int value;
	
	private BlockType(int value) {
		this.value = value;
	}
	
	public int getValue() {
		return this.value;
	}	
}
