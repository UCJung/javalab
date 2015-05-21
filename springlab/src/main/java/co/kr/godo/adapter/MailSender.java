package co.kr.godo.adapter;

@Deprecated
public class MailSender implements IMailSend {

	private MailEntity mailEntity;
	
	@Override
	public void setMailEntity(MailEntity mailEntity) {
		this.mailEntity = mailEntity;
	}
	
	@Override
	public void sendMail() {
		this.send();
	}
	
	private void send() {
		System.out.println("From " + mailEntity.getFrom());
		System.out.println("To " + mailEntity.getTo());
		System.out.println("Subject " + mailEntity.getSubject());
		System.out.println("Body " + mailEntity.getBodyMessage());
		System.out.println("Sended");
	}

}
