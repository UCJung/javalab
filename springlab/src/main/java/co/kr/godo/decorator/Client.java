package co.kr.godo.decorator;

public class Client {
	public static void main(String[] args) {
		OrignalClass orignalClass = new OrignalClass();
		orignalClass.setFirstName("Jung");
		orignalClass.setLastName("Woochul");
		System.out.println(orignalClass.getWelcomeMessage());
	}
}
