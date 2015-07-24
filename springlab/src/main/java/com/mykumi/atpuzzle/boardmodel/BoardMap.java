package com.mykumi.atpuzzle.boardmodel;

import com.mykumi.atpuzzle.blockmodel.Block;
import com.mykumi.atpuzzle.blockmodel.Position;

public class BoardMap {
	private int mapWidth;
	private int mapHeight;
	private Block[][] map;
	
	public BoardMap setMapSize(int mapWidth, int mapHeight) {
		this.mapWidth = mapWidth;
		this.mapHeight = mapHeight;
		map = new Block[mapWidth][mapHeight];
		return this;
	}

	public BoardMap setBlock(Block block) {
		Position p = block.getPosition();
		map[p.getX()][p.getY()] = block;
		return this;
	}
	
	public BoardMap setBlock(Block block, Position position) {
		block.setPosition(position);
		return this.setBlock(block);
	}
	
	public void swapBlock(Position source, Position target) {
		Block temp = map[target.getX()][target.getY()];
		this.setBlock(map[source.getX()][source.getY()], target);
		this.setBlock(temp, source);
	}
	
	public void swapBlock(Block source, Block target) {
		swapBlock(source.getPosition(), target.getPosition());
	}	

	public int getWidth() {
		return this.mapWidth;
	}
	
	public int getHeight() {
		return this.mapHeight;
	}

	public Block[][] getMap() {
		return this.map;
	}

	public Block getBlock(int x, int y) {
		return map[x][y];
	}
	public Block getBlock(Position p) {
		return getBlock(p.getX(),p.getY());
	}
}
