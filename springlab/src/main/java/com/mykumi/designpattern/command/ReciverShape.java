package com.mykumi.designpattern.command;

public class ReciverShape {
	private int positionX = 0;
	private int positionY = 0;
	
	public void setPosition(int x, int y) {
		this.positionX = x;
		this.positionY = y;
		
		System.out.println("set position : "+ this.positionX + ", " + this.positionY);
	}

	public int getPositionX() {
		return positionX;
	}

	public int getPositionY() {
		return positionY;
	}

}
