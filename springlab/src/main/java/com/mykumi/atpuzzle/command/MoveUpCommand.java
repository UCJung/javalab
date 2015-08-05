package com.mykumi.atpuzzle.command;

import com.mykumi.atpuzzle.blockmodel.Block;
import com.mykumi.atpuzzle.boardmodel.BoardMap;
import com.mykumi.atpuzzle.controller.BoardMapControl;

public class MoveUpCommand extends MoveCommand {

	public MoveUpCommand(Block block, BoardMapControl boardMapControl) {
		super(block, boardMapControl);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void excute() {
		BoardMap map = boardMapControl.getBoardMap();
		map.swapBlock(block, map.getBlock(block.getPosition().getX(), block.getPosition().getY() - 1));
	}

}
