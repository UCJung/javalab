package com.mykumi.atpuzzle.controller;

import static org.junit.Assert.*;

import java.util.Random;

import org.hamcrest.core.IsNot;
import org.junit.Before;
import org.junit.Test;

import com.mykumi.atpuzzle.blockmodel.AttackBlock;
import com.mykumi.atpuzzle.blockmodel.Block;
import com.mykumi.atpuzzle.blockmodel.DefenceBlock;
import com.mykumi.atpuzzle.blockmodel.EmptyBlock;
import com.mykumi.atpuzzle.boardmodel.BoardMap;

import static org.hamcrest.CoreMatchers.*;
import static org.mockito.Mockito.*;

public class BoardMapControlTest {
	BoardMap map;
	BoardMapControl boardMapControl;
	int mapWidth = 5;
	int mapHeight = 10;
	
	@Before
	public void setUp() throws Exception {
		boardMapControl = new BoardMapControl();
		map = new BoardMap().setMapSize(mapWidth, mapHeight);
		boardMapControl.setBoardMap(map);
	}

	@Test
	public void createBoardMap() {
		boardMapControl.setBoardMap(map);
		assertThat(boardMapControl.getBoardMap(), is(map));
	}
	
	@Test
	public void clearBoardMap() throws CloneNotSupportedException {
		Block initBlock = new EmptyBlock();
		boardMapControl.clearBoardMap(initBlock);
		
		for (int x = 0 ; x < mapWidth ; x ++) {
			for (int y = 0 ; y < mapHeight ; y ++ ) {
				assertThat(map.getBlock(x, y).getBlockType(), is(initBlock.getBlockType()));
			}
		}
	}
	
	@Test
	public void setDefanceLine() throws CloneNotSupportedException {
		Block initBlock = new EmptyBlock();
		boardMapControl.clearBoardMap(initBlock);
		
		Block defenceBlock = new DefenceBlock();
		boardMapControl.createDefenceLine(defenceBlock);
		
		Block[] rows1 = new Block[mapWidth];
		for (int x = 0 ; x < mapWidth ; x ++) {
			rows1[x] = map.getBlock(x, mapHeight - 1);
			assertThat(rows1[x].getBlockType(), is(defenceBlock.getBlockType()));
		}
		
		Block[] rows2 = new Block[mapWidth];
		boardMapControl.createDefenceLine(defenceBlock);
		for (int x = 0 ; x < mapWidth ; x ++) {
			rows2[x] = map.getBlock(x, mapHeight - 1);
			assertThat(rows2[x].getBlockType(), is(defenceBlock.getBlockType()));
			assertThat(rows1[x], not(rows2));
			assertThat(rows1[x], is(map.getBlock(x, mapHeight - 2)));
		}
	}
	
	@Test
	public void setAttackBlock() throws CloneNotSupportedException {
		Block initBlock = new EmptyBlock();
		boardMapControl.clearBoardMap(initBlock);
		
		Block attackBlock = new AttackBlock();
		
		int posX = new Random().nextInt(4);
		int poxY = 0;
		
		attackBlock.setPosition(posX, poxY);
		boardMapControl.setAttackBlock(attackBlock);
		
		assertThat(map.getBlock(posX, poxY), is(attackBlock));
		assertThat(boardMapControl.getCurrentAttackBlock(), is(attackBlock));
		
		attackBlock.setPosition(posX, poxY + 1);
		assertThat(attackBlock.getPosition().getX(), is(boardMapControl.getCurrentAttackBlock().getPosition().getX()));
		assertThat(attackBlock.getPosition().getY(), is(boardMapControl.getCurrentAttackBlock().getPosition().getY()));
		
		for (int y = 0 ; y < this.mapHeight ; y ++){
			for (int x = 0 ; x < this.mapWidth ; x ++) {
				map.getBlock(x, y).display();
			}
			System.out.println("");
		}		
	}
}
