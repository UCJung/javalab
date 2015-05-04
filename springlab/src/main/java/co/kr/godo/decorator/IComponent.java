package co.kr.godo.decorator;

public interface IComponent {

	public abstract void setFirstName(String firstName);

	public abstract void setLastName(String lastName);

	public abstract String getWelcomeMessage();

}