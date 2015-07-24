package com.mykumi.atpuzzle.blockmodel;

public class AttackBlock extends Block {
	private AttackType attackType;
	
	public AttackBlock() {
		this.blockType = BlockType.Attack;
	}
	
	@Override
	public void display() {
		System.out.print(this.blockType.getValue());
	}
	
}
