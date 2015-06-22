package com.mykumi.springlab.chat01.user.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;

public class MockMailSender implements MailSender {
	// 수신자의 주소를 저장하는 배열
	private List<String> requests = new ArrayList<String>();
	
	public List<String> getRequests() {
		return requests;
	}
	
	@Override
	public void send(SimpleMailMessage simpleMailMessage) throws MailException {
		// 전송요청에 대하여 수신자의 메일을 저장한다.
		requests.add(simpleMailMessage.getTo()[0]);
	}

	@Override
	public void send(SimpleMailMessage[] simpleMailMessages)
			throws MailException {

	}

}
