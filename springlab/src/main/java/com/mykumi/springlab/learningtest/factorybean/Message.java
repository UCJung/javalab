package com.mykumi.springlab.learningtest.factorybean;

public class Message {
	String text;
	
	// 생성자를 private로 선언함
	private Message(String text) {
		this.text = text;
	}
	
	public String getText() {
		return text;
	}
	
	// 별도의 public Static Method를 통하여 Message Instance 생성
	public static Message newMessage(String text) {
		return new Message(text);
	}
}
