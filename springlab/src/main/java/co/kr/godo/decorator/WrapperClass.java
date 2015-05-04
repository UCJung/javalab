package co.kr.godo.decorator;

public class WrapperClass extends Decorator {
	public String getWelcomeMessage() {
		String result = "Hi! Nice to meet You. ";
		result = result + orignalClass.getWelcomeMessage();
		return result;
	}
}
