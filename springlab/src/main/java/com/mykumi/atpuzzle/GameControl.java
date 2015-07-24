package com.mykumi.atpuzzle;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;
import java.util.Scanner;

import com.mykumi.atpuzzle.blockmodel.AttackBlock;
import com.mykumi.atpuzzle.blockmodel.Block;

public class GameControl {
	private Board board = new Board(5, 10);
	private Queue<Block> nextAttackers = new LinkedList<Block>();
	private Block currentAttacker;
	private int playTrun = 0;
	
	public void run() {
		// 보드 초기화
		this.initPlay();
		
		Scanner sc = new Scanner(System.in);
		while(true) {
			
			String s = sc.next();
			if (s.equals("1")) break;
			if (s.equals("2")) {
				// 공격결과처리
				board.attack();
				// 방어블럭 생성
				board.createDefenceLine();			
				// 공격블럭 생성 배치
				board.setAttacker(this.getAttackBlock());
			}
			if (s.equals("4")) board.AttackerMoveLeft();
			if (s.equals("6")) board.AttackerMoveRight();
			board.redraw();
			
			playTrun ++;
		}		
	}
	
	private void initPlay() {
		this.initnextAttackers();
		board.initMap();
		board.createDefenceLine();			
		if (playTrun == 0) {
			board.createDefenceLine();
		} 
		board.setAttacker(this.getAttackBlock());
		board.redraw();
	}

	private Block getAttackBlock() {
		Block attackBlock = nextAttackers.poll();
		this.nextAttackers.add(new AttackBlock());
		return attackBlock;
	}
	
	private void initnextAttackers() {
		for ( int i = 0 ; i < 5 ; i ++ ) {
			this.nextAttackers.add(new AttackBlock());
		}
	}
}
