package com.mykumi.designpattern.adapter;

public class MailEntity {
	private String to;
	private String from;
	private String subject;
	private String bodyMessage;

	public MailEntity(String to, String from, String subject,
			String bodyMessage) {
		this.to = to;
		this.from = from;
		this.subject = subject;
		this.bodyMessage = bodyMessage;
	}

	public String getTo() {
		return to;
	}

	public String getFrom() {
		return from;
	}

	public String getSubject() {
		return subject;
	}

	public String getBodyMessage() {
		return bodyMessage;
	}

}