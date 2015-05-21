package com.mykumi.designpattern.flyweight;


public class UnformatedNotifyMessage extends NotifyMessage {

	@Override
	public void setMessage(String messageBody) {
		this.messageBody = messageBody;

	}

	@Override
	public void displayMessage() {
		System.out.println(this.messageBody);
	}

}
