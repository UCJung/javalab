package com.mykumi.designpattern.command;
import java.util.ArrayList;

public class ClinetCommand {
	private static ArrayList<MoveCommand> commands = new ArrayList<MoveCommand>();
	private static ReciverShape reciver;
	private static int commandIndex = -1;

	public static void main(String[] args) {
		reciver = new ReciverShape();
		MoveCommand moveUp = new MoveUpCommand(reciver);
		MoveCommand moveDown = new MoveDownCommand(reciver);
		
		handle(moveUp);
		handle(moveUp);
		handle(moveUp);
		handle(moveDown);
		undo();
		undo();
		undo();
		undo();
	}
	
	private static void handle(MoveCommand command) {
		command.excute();
		commands.add(command);
		commandIndex ++;
	}
	
	public static void undo() {
		commands.get(commandIndex).undo();
		commandIndex --;
	}
}
