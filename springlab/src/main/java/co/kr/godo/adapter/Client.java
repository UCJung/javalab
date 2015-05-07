package co.kr.godo.adapter;

public class Client {

	public static void main(String[] args) {
		MailSender mailSender = new MailSender();
		mailSender.setMailEntity(new MailEntity("Jung", "Kim", "Hi Kim", "See you again"));
		mailSender.sendMail();
	}

}
