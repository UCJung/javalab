package com.mykumi.atpuzzle.blockmodel;

public abstract class Block {
	protected BlockType blockType; 
	protected Position position;
	
	public abstract void display();

	public BlockType getBlockType() {
		return blockType;
	}
	
	public void setPosition(int x, int y) {
		if (position == null) {
			this.position = new Position();
		}
		this.position.setX(x);
		this.position.setY(y);
	}
	
	public void setPosition(Position p) {
		this.position = p;
	}
	
	public Position getPosition() {
		return this.position;
	}
}
