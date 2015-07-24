package com.mykumi.atpuzzle.blockmodel;

public class DefenceBlock extends Block {

	public DefenceBlock() {
		this.blockType = BlockType.Defend;
	}
	
	@Override
	public void display() {
		System.out.print(this.blockType.getValue());
	}
	
}
