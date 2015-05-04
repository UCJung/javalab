package co.kr.godo.decorator;

public class Wrapper2Class extends Decorator {

	public String getWelcomeMessage() {
		String result = "How are You!";
		result = result + orignalClass.getWelcomeMessage();
		return result;
	}
}
