package com.mykumi.designpattern.command;

import java.util.ArrayList;

public class CommandInvokor {
	private ArrayList<MoveCommand> commands = new ArrayList<MoveCommand>();
	private int commandIndex = -1;

	public void handle(MoveCommand command) {
		command.excute();
		commands.add(command);
		commandIndex ++;
	}
	
	public void undo() {
		commands.get(commandIndex).undo();
		commandIndex --;
	}
	
}
