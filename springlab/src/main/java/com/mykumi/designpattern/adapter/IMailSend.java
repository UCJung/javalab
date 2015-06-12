package com.mykumi.designpattern.adapter;

public interface IMailSend {

	public abstract void setMailEntity(MailEntity mailEntity);

	public abstract void sendMail();

}