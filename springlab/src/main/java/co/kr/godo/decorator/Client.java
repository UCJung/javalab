package co.kr.godo.decorator;

public class Client {
	public static void main(String[] args) {
		IComponent iComponent = new OrignalClass();
		iComponent.setFirstName("Jung");
		iComponent.setLastName("Woochul");
		System.out.println(iComponent.getWelcomeMessage());
	}
}
