package com.mykumi.atpuzzle.boardmodel;

import java.util.Random;

import javax.swing.JFrame;

import com.mykumi.atpuzzle.blockmodel.Block;
import com.mykumi.atpuzzle.blockmodel.BlockType;
import com.mykumi.atpuzzle.blockmodel.DefenceBlock;
import com.mykumi.atpuzzle.blockmodel.EmptyBlock;

public class Board {
	private int mapWidth;
	private int mapHeight;
	private Block[][] map;
	private int attackPositionX;
	private int attackPositionY;
	
	public Board(int mapWidth, int mapHeight) {
		this.mapWidth = mapWidth;
		this.mapHeight = mapHeight;
		
		map = new Block[mapWidth][mapHeight];
		
		this.initMap();
	}
	
	public void initMap() {
		this.clearMap();
	}
	
	public void clearMap() {
		for (int y = 0 ; y < this.mapHeight ; y ++)
			for (int x = 0 ; x < this.mapWidth ; x ++) 
				map[x][y] = new EmptyBlock();
	}
	
	public void redraw() {
		for (int y = 0 ; y < this.mapHeight ; y ++){
			for (int x = 0 ; x < this.mapWidth ; x ++) {
				map[x][y].display();
			}
			System.out.println("");
		}
	}
	
	public void createDefenceLine() {
		for (int x = 0 ; x < this.mapWidth ; x++) {
			for (int y = 0 ; y < this.mapHeight - 1 ; y++) {
				Block block = map[x][y+1];
				if (block.getBlockType() != BlockType.Empty) {
					map[x][y] = new DefenceBlock();
					break;
				}
				
				if ( y == this.mapHeight - 2) {
					map[x][y+1] = new DefenceBlock();
					break;					
				}
			}
		}
	}

	public void setAttacker(Block attackBlock) {
		this.attackPositionX = new Random().nextInt(mapWidth - 1);
		this.attackPositionY = 0;
		map[this.attackPositionX][this.attackPositionY] = attackBlock;
	}

	public void AttackerMoveLeft() {
		if (attackPositionX > 0) {
			exChangePosition(attackPositionX, attackPositionY,  attackPositionX-1, attackPositionY);
			attackPositionX --;
		}
	}
	
	public void AttackerMoveRight() {
		if (attackPositionX < mapWidth - 1) {
			exChangePosition(attackPositionX, attackPositionY,  attackPositionX+1, attackPositionY);
			attackPositionX ++;
		}
	}	
	
	private void exChangePosition(int sourceX, int sourceY, int targetX, int targetY) {
		Block temp = map[targetX][targetY];
		map[targetX][targetY] = map[sourceX][sourceY];
		map[sourceX][sourceY] = temp;		
	}

	public void attack() {
		int attackPointX = attackPositionX;
		int attackPointY = 0;
		
		attackPointY = calculateAttackPoint(attackPointX, attackPointY);
		attackProcess(attackPointX, attackPointY);
		reassembleBlocks();
		
	}

	private int calculateAttackPoint(int attackPointX, int attackPointY) {
		for (int y = 0 ; y < mapHeight ; y++) {
			if (map[attackPointX][y].getBlockType() == BlockType.Defend) {
				attackPointY = y;
				break;
			}
		}
		return attackPointY;
	}

	// 공격에 대한 처리 수행
	private void attackProcess(int attackPointX, int attackPointY) {
		map[attackPositionX][attackPositionY] = new EmptyBlock();		

		// attack process 
		for (int y = attackPointY - 1 ; y < attackPointY + 2 ; y ++) {
			if ( y < 0 || y >= mapHeight) continue;
			for (int x = attackPointX - 1 ; x < attackPointX + 2 ; x ++) {
				if ( x < 0 || x >= mapWidth) continue;
				map[x][y] = new EmptyBlock();
			}
		}
	}

	// 공격 후 수비블럭에 대한 조배치 작업(공백이 없도록)
	private void reassembleBlocks() {
		// relocate block 
		int startX = 0;
		int startY = mapHeight - 2;
		int scope = 3; // Attack의 영향범위
		for (int k = 0 ; k < scope ; k ++) {
			for (int y = startY ; y >= 0 ; y --) {
				for (int x = startX ; x < mapWidth ; x ++) {
					if (map[x][y].getBlockType() != BlockType.Empty 
							&& map[x][y+1].getBlockType() == BlockType.Empty) {
						exChangePosition(x, y, x, y+1);
					}
				}
			}
		}
	}
}
