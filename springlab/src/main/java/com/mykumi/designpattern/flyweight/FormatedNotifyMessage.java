package com.mykumi.designpattern.flyweight;


public class FormatedNotifyMessage extends NotifyMessage {
	private String messageFormat;
	private String displayMessage;

	public FormatedNotifyMessage(String key) {
		this.setMessageFormat(key);
	}
	
	@Override
	public void setMessage(String messageBody) {
		this.messageBody = messageBody;
		this.displayMessage = messageFormat + messageBody;
	}

	@Override
	public void displayMessage() {
		System.out.println(this.displayMessage);
	}
	
	private void setMessageFormat(String key) {
		this.messageFormat =  key;
	}

}
