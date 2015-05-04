package co.kr.godo.decorator;

public class WrapperClass implements IComponent {
	private IComponent orignalClass = new OrignalClass();
	
	@Override
	public void setFirstName(String firstName) {
		orignalClass.setFirstName(firstName);
	}

	@Override
	public void setLastName(String lastName) {
		orignalClass.setLastName(lastName);
	}
	
	@Override
	public String getWelcomeMessage() {
		String result = "Hi! Nice to meet You. ";
		result = result + orignalClass.getWelcomeMessage();
		return result;
	}
}
