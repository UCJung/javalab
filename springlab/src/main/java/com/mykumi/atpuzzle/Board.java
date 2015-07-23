package com.mykumi.atpuzzle;

import com.mykumi.atpuzzle.blockmodel.Block;

public class Board {
	private int mapWidth;
	private int mapHeight;
	private Block[][] map;
	
	public Board(int mapWidth, int mapHeight) {
		this.mapWidth = mapWidth;
		this.mapHeight = mapHeight;
		
		map = new Block[mapHeight][mapWidth];
	}
	
	public boolean initMap() {
		return true;
	}
	
	public void clearMap() {
		for (int i = 0 ; i < this.mapHeight ; i ++) {
			
		}
	}
}
