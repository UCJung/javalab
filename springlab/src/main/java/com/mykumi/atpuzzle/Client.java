package com.mykumi.atpuzzle;

import java.util.Scanner;

import com.mykumi.atpuzzle.controller.GameControl;

public class Client {

	public static void main(String[] args) {
		
		GameControl gc = new GameControl();
		gc.run();
	}
}
