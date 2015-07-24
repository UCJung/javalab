package com.mykumi.atpuzzle.blockmodel;

import java.util.Random;

public class AttackBlock extends Block {
	private AttackType attackType;
	
	public AttackBlock() {
		this.blockType = BlockType.Attack;
		this.attackType = AttackType.fromValue(new Random().nextInt(4));
		System.out.println(this.attackType.getValue());
	}

	@Override
	public void display() {
		System.out.print(this.blockType.getValue());
	}
	
}
