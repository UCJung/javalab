package com.mykumi.atpuzzle.blockmodel;

public abstract class Block implements Cloneable {
	protected BlockType blockType; 
	protected Position position;
	
	public abstract void display();

	public BlockType getBlockType() {
		return blockType;
	}
	
	public Block setPosition(int x, int y) {
		if (position == null) {
			this.position = new Position();
		}
		this.position.setX(x);
		this.position.setY(y);
		
		return this;
	}
	
	public Block setPosition(Position p) {
		this.position = p;
		return this;
	}
	
	public Position getPosition() {
		return this.position;
	}
	
	public Object clone() throws CloneNotSupportedException {
		Block a = (Block)super.clone();
		return a;
	}	
}
