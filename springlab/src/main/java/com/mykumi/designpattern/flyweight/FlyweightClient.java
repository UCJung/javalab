package com.mykumi.designpattern.flyweight;

import java.util.Scanner;

public class FlyweightClient {
	public static void main(String[] args) {
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);

		String name = "";

		System.out.println("Input name ");
		while(true) {
			name = sc.nextLine();
			if (name.equals("exit")) {
				break;
			}
			displayWelcomeMessage(name);
		}
	}

	private static void displayWelcomeMessage(String messageBody) {
		NotifyMessage formated = new FormatedNotifyMessage("welcome");
		formated.setMessage(messageBody);
		formated.displayMessage();
	}
}
