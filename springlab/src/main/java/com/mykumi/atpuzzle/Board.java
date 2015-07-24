package com.mykumi.atpuzzle;

import java.util.Random;

import javax.swing.JFrame;

import com.mykumi.atpuzzle.blockmodel.Block;
import com.mykumi.atpuzzle.blockmodel.BlockType;
import com.mykumi.atpuzzle.blockmodel.DefendBlock;
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
		
		map = new Block[mapHeight][mapWidth];
		
		this.initMap();
	}
	
	public void initMap() {
		this.clearMap();
	}
	
	public void clearMap() {
		for (int i = 0 ; i < this.mapHeight ; i ++)
			for (int j = 0 ; j < this.mapWidth ; j ++) 
				map[i][j] = new EmptyBlock();
	}
	
	public void redraw() {
		for (int i = 0 ; i < this.mapHeight ; i ++){
			for (int j = 0 ; j < this.mapWidth ; j ++) {
				map[i][j].display();
			}
			System.out.println("");
		}
	}
	
	public void createDefenceLine() {
		for (int i = 0 ; i < this.mapWidth ; i++) {
			for (int j = 0 ; j < this.mapHeight - 1 ; j++) {
				Block block = map[j+1][i];
				if (block.getBlockType() != BlockType.Empty) {
					map[j][i] = new DefendBlock();
					break;
				}
				
				if ( j == this.mapHeight - 2) {
					map[j+1][i] = new DefendBlock();
					break;					
				}
			}
		}
	}

	public void setAttacker(Block attackBlock) {
		this.attackPositionX = new Random().nextInt(mapWidth - 1);
		this.attackPositionY = 0;
		map[this.attackPositionY][this.attackPositionX] = attackBlock;
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
		Block temp = map[targetY][targetX];
		map[targetY][targetX] = map[sourceY][sourceX];
		map[sourceY][sourceX] = temp;		
	}

	public void attack() {
		int attackPointX = attackPositionX;
		int attackPointY = 0;
		
		attackPointY = calculateAttackPoint(attackPointX, attackPointY);
		attackProcess(attackPointX, attackPointY);
		reassembleBlocks();
		
	}

	private int calculateAttackPoint(int attackPointX, int attackPointY) {
		for (int i = 0 ; i < mapHeight ; i++) {
			if (map[i][attackPointX].getBlockType() == BlockType.Defend) {
				attackPointY = i;
				break;
			}
		}
		return attackPointY;
	}

	// 공격에 대한 처리 수행
	private void attackProcess(int attackPointX, int attackPointY) {
		map[attackPositionY][attackPositionX] = new EmptyBlock();		

		// attack process 
		for (int i = attackPointY - 1 ; i < attackPointY + 2 ; i ++) {
			if ( i < 0 || i >= mapHeight) continue;
			for (int j = attackPointX - 1 ; j < attackPointX + 2 ; j ++) {
				if ( j < 0 || j >= mapWidth) continue;
				map[i][j] = new EmptyBlock();
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
			for (int i = startY ; i >= 0 ; i --) {
				for (int j = startX ; j < mapWidth ; j ++) {
					if (map[i][j].getBlockType() != BlockType.Empty 
							&& map[i+1][j].getBlockType() == BlockType.Empty) {
						exChangePosition(j, i, j, i+1);
					}
				}
			}
		}
	}
}
