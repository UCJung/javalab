package com.mykumi.atpuzzle.controller;

import com.mykumi.atpuzzle.blockmodel.Block;
import com.mykumi.atpuzzle.blockmodel.BlockType;
import com.mykumi.atpuzzle.blockmodel.EmptyBlock;
import com.mykumi.atpuzzle.blockmodel.Position;
import com.mykumi.atpuzzle.boardmodel.BoardMap;

public class BoardMapControl {
	private BoardMap boardMap;
	private int mapWidth;
	private int mapHeight;
	private Block currentAttackBlock;

	public BoardMap getBoardMap() {
		return boardMap;
	}	
	
	public void setBoardMap(BoardMap boardMap) {
		this.boardMap = boardMap;
		this.mapWidth = boardMap.getWidth();
		this.mapHeight = boardMap.getHeight();
	}
	
	// fill map to parameter block
	public void clearBoardMap(Block initBlock) throws CloneNotSupportedException {
		for (int x = 0 ; x < mapWidth ; x ++) {
			for (int y = 0 ; y < mapHeight ; y ++) {
				Block block = (Block)initBlock.clone();
				boardMap.setBlock(block, new Position(x,y));
			}
		}
	}

	// create defence block line at buttom of map
	public void createDefenceLine(Block defenceBlock) throws CloneNotSupportedException {
		// all defenceBlock move up 1 cell 
		MoveUpSameTypeOfBlocks(defenceBlock.getBlockType());
		
		// create and add defenceBlock
		for (int x = 0 ; x < mapWidth ; x ++) {
			Block block = (Block)defenceBlock.clone();
			boardMap.setBlock(block, new Position(x, mapHeight - 1));			
		}
	}

	// all same type of block move up 1 cell 
	private void MoveUpSameTypeOfBlocks(BlockType blockType) {
		for (int x = 0 ; x < mapWidth ; x ++) {
			for (int y = 0 ; y < mapHeight ; y ++) {
				if (boardMap.getBlock(x, y).getBlockType() == blockType) {
					boardMap.swapBlock(new Position(x,y), new Position(x,y-1));
				}
			}
		}
	}

	// set Attack Block to map & property
	public void setAttackBlock(Block attackBlock) {
		this.currentAttackBlock = attackBlock;
		boardMap.setBlock(attackBlock);
	}

	// get current attack block
	public Block getCurrentAttackBlock() {
		return currentAttackBlock;
	}
	
}
