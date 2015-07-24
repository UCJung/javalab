package com.mykumi.atpuzzle.blockmodel;

public class ItemBlock extends Block {

	public ItemBlock() {
		this.blockType = BlockType.Item;
	}
	
	@Override
	public void display() {
		System.out.print(this.blockType.getValue());
	}
}
