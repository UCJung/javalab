package co.kr.godo.decorator;

public class WrapperClass {
	private OrignalClass orignalClass = new OrignalClass();
	
	public void setFirstName(String firstName) {
		orignalClass.setFirstName(firstName);
	}

	public void setLastName(String lastName) {
		orignalClass.setLastName(lastName);
	}
	
	public String getWelcomeMessage() {
		String result = "Hi! Nice to meet You. ";
		result = result + orignalClass.getWelcomeMessage();
		return result;
	}
}
