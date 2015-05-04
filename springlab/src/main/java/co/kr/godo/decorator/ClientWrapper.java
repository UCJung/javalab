package co.kr.godo.decorator;

public class ClientWrapper {

	public static void main(String[] args) {
		IComponent iComponent = new WrapperClass();
		iComponent.setFirstName("Jung");
		iComponent.setLastName("Woochul");
		System.out.println(iComponent.getWelcomeMessage());
	}

}
