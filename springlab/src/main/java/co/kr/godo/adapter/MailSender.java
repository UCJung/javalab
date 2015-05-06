package co.kr.godo.adapter;

public class MailSender {
	private MailEntity parameterObject;
	
	public void setMailFrom(MailEntity parameterObject) {
		this.parameterObject = parameterObject;
	}
	
	public void sendMail() {
		this.send();
	}
	
	private void send() {
		System.out.println("From " + parameterObject.from);
		System.out.println("To " + parameterObject.to);
		System.out.println("Subject " + parameterObject.subject);
		System.out.println("Body " + parameterObject.bodyMessage);
		System.out.println("Sended");
	}
}
