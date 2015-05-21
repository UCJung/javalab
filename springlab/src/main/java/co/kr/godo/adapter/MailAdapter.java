package co.kr.godo.adapter;

import co.kr.godo.adapter.newmail.NewMailSender;

public class MailAdapter extends NewMailSender implements IMailSend {
	private MailEntity mailEntity;
	
	@Override
	public void setMailEntity(MailEntity mailEntity) {
		this.mailEntity = mailEntity;
	}
	
	@Override
	public void sendMail() {
		this.send(mailEntity.getTo(), 
				mailEntity.getFrom(), 
				mailEntity.getSubject(), 
				mailEntity.getBodyMessage());
	}
}
