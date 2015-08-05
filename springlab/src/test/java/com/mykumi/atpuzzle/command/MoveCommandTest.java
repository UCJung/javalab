package com.mykumi.atpuzzle.command;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import static org.mockito.Mockito.*;

import org.junit.Before;
import org.junit.Test;

import com.mykumi.atpuzzle.blockmodel.AttackBlock;
import com.mykumi.atpuzzle.blockmodel.Block;
import com.mykumi.atpuzzle.blockmodel.EmptyBlock;
import com.mykumi.atpuzzle.boardmodel.BoardMap;
import com.mykumi.atpuzzle.controller.BoardMapControl;

public class MoveCommandTest {
	BoardMap map;
	BoardMapControl boardMapControl;
	CommandInvokor commandHandler;
	
	int mapWidth = 5;
	int mapHeight = 10;
	
	@Before
	public void setUp() throws Exception {
		boardMapControl = new BoardMapControl();
		map = new BoardMap().setMapSize(mapWidth, mapHeight);
		boardMapControl.setBoardMap(map);	
		commandHandler = new CommandInvokor();
		
		Block initBlock = new EmptyBlock();
		boardMapControl.clearBoardMap(initBlock);	
		
	}

	@Test
	public void MoveUp() {
		int posX = 2;
		int posY = 3;
		Block attackBlock = new AttackBlock().setPosition(posX, posY);
		boardMapControl.setAttackBlock(attackBlock);		
		
		MoveCommand moveCommand = new MoveUpCommand(attackBlock, boardMapControl);
		commandHandler.handle(moveCommand);
		
		assertThat(map.getBlock(posX, posY), not(attackBlock));
		assertThat(map.getBlock(posX, posY-1), is(attackBlock));
	}
	
	@Test
	public void MoveDown() {
		int posX = 2;
		int posY = 3;
		Block attackBlock = new AttackBlock().setPosition(posX, posY);
		boardMapControl.setAttackBlock(attackBlock);		
		
		MoveCommand moveCommand = new MoveDownCommand(attackBlock, boardMapControl);
		commandHandler.handle(moveCommand);
		
		assertThat(map.getBlock(posX, posY), not(attackBlock));
		assertThat(map.getBlock(posX, posY+1), is(attackBlock));
	}	
	
	@Test
	public void MoveLeft() {
		int posX = 2;
		int posY = 3;
		Block attackBlock = new AttackBlock().setPosition(posX, posY);
		boardMapControl.setAttackBlock(attackBlock);		
		
		MoveCommand moveCommand = new MoveLeftCommand(attackBlock, boardMapControl);
		commandHandler.handle(moveCommand);
		
		assertThat(map.getBlock(posX, posY), not(attackBlock));
		assertThat(map.getBlock(posX-1, posY), is(attackBlock));
	}		

	
	@Test
	public void MoveRight() {
		int posX = 2;
		int posY = 3;
		Block attackBlock = new AttackBlock().setPosition(posX, posY);
		boardMapControl.setAttackBlock(attackBlock);		
		
		MoveCommand moveCommand = new MoveRightCommand(attackBlock, boardMapControl);
		commandHandler.handle(moveCommand);
		
		assertThat(map.getBlock(posX, posY), not(attackBlock));
		assertThat(map.getBlock(posX + 1, posY), is(attackBlock));
	}		
}
