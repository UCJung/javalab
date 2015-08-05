package com.mykumi.atpuzzle.command;

import com.mykumi.atpuzzle.blockmodel.Block;
import com.mykumi.atpuzzle.controller.BoardMapControl;

public abstract class MoveCommand {
	protected BoardMapControl boardMapControl;
	protected Block block;
	protected int movingUnit = 10;
	
	public MoveCommand(Block block, BoardMapControl boardMapControl) {
		this.block = block;
		this.boardMapControl = boardMapControl;
	}
	
	public abstract void excute();
}
