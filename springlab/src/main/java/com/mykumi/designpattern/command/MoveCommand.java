package com.mykumi.designpattern.command;

public abstract class MoveCommand {
	protected ReciverShape reciver;
	protected int movingUnit = 10;
	
	public MoveCommand(ReciverShape reciver) {
		this.reciver = reciver;
	}
	
	public abstract void excute();
	public abstract void undo();
}
