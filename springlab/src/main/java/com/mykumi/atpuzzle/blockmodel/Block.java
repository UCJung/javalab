package com.mykumi.atpuzzle.blockmodel;

public abstract class Block {
	protected BlockType blockType; 
	
	public abstract void display();

	public BlockType getBlockType() {
		return blockType;
	}
}
