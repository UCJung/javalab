package co.kr.godo.adapter;

public class MailEntity {
	public String to;
	public String from;
	public String subject;
	public String bodyMessage;

	public MailEntity(String to, String from, String subject,
			String bodyMessage) {
		this.to = to;
		this.from = from;
		this.subject = subject;
		this.bodyMessage = bodyMessage;
	}
}