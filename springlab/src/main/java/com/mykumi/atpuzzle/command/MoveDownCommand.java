package com.mykumi.atpuzzle.command;

import com.mykumi.atpuzzle.blockmodel.Block;
import com.mykumi.atpuzzle.boardmodel.BoardMap;
import com.mykumi.atpuzzle.controller.BoardMapControl;

public class MoveDownCommand extends MoveCommand {

	public MoveDownCommand(Block block, BoardMapControl boardMapControl) {
		super(block, boardMapControl);
	}

	@Override
	public void excute() {
		BoardMap map = boardMapControl.getBoardMap();
		map.swapBlock(block, map.getBlock(block.getPosition().getX(), block.getPosition().getY() + 1));
	}

}
