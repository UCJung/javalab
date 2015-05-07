package co.kr.godo.adapter;

import co.kr.godo.adapter.newmail.NewMailSender;

public class MailSender {
	private MailEntity mailEntity;
	private NewMailSender newMailSender = new NewMailSender();
	
	public void setMailEntity(MailEntity mailEntity) {
		this.mailEntity = mailEntity;
	}
	
	public void sendMail() {
		newMailSender.send(mailEntity.getTo(), 
				mailEntity.getFrom(), 
				mailEntity.getSubject(), 
				mailEntity.getBodyMessage());
	}
	
	@Deprecated
	private void send() {
		System.out.println("From " + mailEntity.getFrom());
		System.out.println("To " + mailEntity.getTo());
		System.out.println("Subject " + mailEntity.getSubject());
		System.out.println("Body " + mailEntity.getBodyMessage());
		System.out.println("Sended");
	}
}
