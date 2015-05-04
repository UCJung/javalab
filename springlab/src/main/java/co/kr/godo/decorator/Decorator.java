package co.kr.godo.decorator;

public abstract class Decorator implements IComponent {

	protected IComponent orignalClass = new OrignalClass();

	public abstract String getWelcomeMessage();

	public void setFirstName(String firstName) {
		orignalClass.setFirstName(firstName);
	}

	public void setLastName(String lastName) {
		orignalClass.setLastName(lastName);
	}
}