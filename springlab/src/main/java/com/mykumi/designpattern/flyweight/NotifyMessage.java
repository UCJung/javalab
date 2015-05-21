package com.mykumi.designpattern.flyweight;

public abstract class NotifyMessage {
	protected String messageBody;
	
	abstract public void setMessage(String messageBody);
	abstract public void displayMessage();
}
