package com.mykumi.atpuzzle.blockmodel;

public class DefendBlock extends Block {

	public DefendBlock() {
		this.blockType = BlockType.Defend;
	}
	
	@Override
	public void display() {
		System.out.print(this.blockType.getValue());
	}
	
}
