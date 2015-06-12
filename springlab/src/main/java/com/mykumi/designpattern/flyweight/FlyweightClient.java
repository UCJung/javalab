package com.mykumi.designpattern.flyweight;

import java.util.Scanner;

public class FlyweightClient {
	private static FlyweightNotifyMessageFactory nmFactory = new FlyweightNotifyMessageFactory();  
	
	public static void main(String[] args) {
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
		NotifyMessage welcomNotifyMessage = nmFactory.getFormatedNotifyMessage("welcome");
		welcomNotifyMessage.setMessage(messageBody);
		welcomNotifyMessage.displayMessage();
	}
}
