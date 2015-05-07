package co.kr.godo.adapter;

public class NewClient {

	public static void main(String[] args) {
		IMailSend mailSender = new MailAdapter();
		mailSender.setMailEntity(new MailEntity("Jung", "Kim", "Hi Kim", "See you again"));
		mailSender.sendMail();
	}

}
