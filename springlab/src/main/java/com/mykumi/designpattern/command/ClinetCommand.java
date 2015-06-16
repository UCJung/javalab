package com.mykumi.designpattern.command;

public class ClinetCommand {
	public static void main(String[] args) {
		ReciverShape reciver = new ReciverShape();
		CommandInvokor invokor = new CommandInvokor();
		MoveCommand moveUp = new MoveUpCommand(reciver);
		MoveCommand moveDown = new MoveDownCommand(reciver);
		
		invokor.handle(moveUp);
		invokor.handle(moveUp);
		invokor.handle(moveUp);
		invokor.handle(moveDown);
		invokor.undo();
		invokor.undo();
		invokor.undo();
		invokor.undo();
	}	
}
