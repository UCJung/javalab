package com.mykumi.atpuzzle.blockmodel;

public class EmptyBlock extends Block {

	public EmptyBlock() {
		this.blockType = BlockType.Empty;
	}
	
	@Override
	public void display() {
		System.out.print(this.blockType.getValue());
	}
}
