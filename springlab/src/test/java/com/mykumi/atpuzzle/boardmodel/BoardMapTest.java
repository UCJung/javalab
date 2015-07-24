package com.mykumi.atpuzzle.boardmodel;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import static org.mockito.Mockito.*;

import org.junit.Test;
import org.junit.Before;

import com.mykumi.atpuzzle.blockmodel.Block;
import com.mykumi.atpuzzle.blockmodel.EmptyBlock;
import com.mykumi.atpuzzle.blockmodel.Position;

public class BoardMapTest {
	private BoardMap map;
	private Block[][] mArray;
	
	@Before
	public void setup() {
		map = new BoardMap();
		map.setMapSize(5, 10);
		mArray = map.getMap(); 
	}
	
	@Test
	public void setMapSize() {
		map.setMapSize(5, 10);
		assertThat(map.getWidth(), is(5));
		assertThat(map.getHeight(), is(10));
	}
	
	@Test
	public void setBlock() {
		Block block = new EmptyBlock();
		Position p = new Position(1, 1);
		block.setPosition(p);

		map.setBlock(block);
		assertThat(mArray[p.getX()][p.getY()], is(block));

		Block block2 = new EmptyBlock();
		Position p2 = new Position(2, 2);

		map.setBlock(block2, p2);
		assertThat(mArray[2][2],is(block2));
		

	}
	
	@Test
	public void swapBlock() {
		Block b1 = new EmptyBlock().setPosition(1, 1);
		Block b2 = new EmptyBlock().setPosition(2, 2);
		
		map.setBlock(b1);
		map.setBlock(b2);
		
		map.swapBlock(new Position(1, 1), new Position(2, 2));
		assertThat(b1, is(map.getBlock(2, 2)));
		assertThat(b2, is(map.getBlock(1, 1)));		
		
		map.swapBlock(b1, b2);
		assertThat(b1, is(map.getBlock(1, 1)));
		assertThat(b2, is(map.getBlock(2, 2)));		
	}

}
