package co.kr.godo.adapter.newmail;

public class NewMailSender {
	public void send(String to, String from, String subject,
			String bodyMessage) {
		System.out.println("From " + from);
		System.out.println("To " + to);
		System.out.println("Subject " + subject);
		System.out.println("Body " + bodyMessage);
		System.out.println("Sended");		
	}
}
