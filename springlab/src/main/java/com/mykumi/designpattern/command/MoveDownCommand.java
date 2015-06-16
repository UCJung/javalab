package com.mykumi.designpattern.command;

public class MoveDownCommand extends MoveCommand {

	public MoveDownCommand(ReciverShape reciver) {
		super(reciver);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void excute() {
		this.reciver.setPosition(this.reciver.getPositionX() + this.movingUnit, this.reciver.getPositionY());
	}

	@Override
	public void undo() {
		this.reciver.setPosition(this.reciver.getPositionX() - this.movingUnit, this.reciver.getPositionY());
	}

}
