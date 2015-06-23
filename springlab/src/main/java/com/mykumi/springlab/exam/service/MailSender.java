package com.mykumi.springlab.exam.service;

import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;

public interface MailSender {
	void send(SimpleMailMessage simpleMailMessage) throws MailException;
	void send(SimpleMailMessage[] simpleMailMessages) throws MailException;
}
