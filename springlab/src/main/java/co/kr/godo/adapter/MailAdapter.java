package co.kr.godo.adapter;

import co.kr.godo.adapter.newmail.NewMailSender;

public class MailAdapter implements IMailSend {
	private MailEntity mailEntity;
	private NewMailSender newMailSender = new NewMailSender();
	
	@Override
	public void setMailEntity(MailEntity mailEntity) {
		this.mailEntity = mailEntity;
	}
	
	@Override
	public void sendMail() {
		newMailSender.send(mailEntity.getTo(), 
				mailEntity.getFrom(), 
				mailEntity.getSubject(), 
				mailEntity.getBodyMessage());
	}
}
