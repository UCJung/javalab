package com.mykumi.springlab.chat01.user.service;

import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;

public class DummyMailSender implements MailSender {
	private String host;
	
	@Override
	public void send(SimpleMailMessage simpleMailMessage) throws MailException {
		// TODO Auto-generated method stub

	}

	@Override
	public void send(SimpleMailMessage[] simpleMailMessages)
			throws MailException {
		// TODO Auto-generated method stub

	}

	public void setHost(String host) {
		this.host = host;
	}

}
