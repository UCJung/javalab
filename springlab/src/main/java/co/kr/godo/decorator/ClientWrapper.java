package co.kr.godo.decorator;

public class ClientWrapper {

	public static void main(String[] args) {
		WrapperClass wrapperClass = new WrapperClass();
		wrapperClass.setFirstName("Jung");
		wrapperClass.setLastName("Woochul");
		System.out.println(wrapperClass.getWelcomeMessage());
	}

}
