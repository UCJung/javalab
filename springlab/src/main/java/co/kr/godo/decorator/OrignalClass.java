package co.kr.godo.decorator;

public class OrignalClass {
	private String firstName;
	private String lastName;
	
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	public String getWelcomeMessage() {
		return "Welcome.. " + this.getName();
	}
	
	private String getName() {
		return this.firstName + " " + this.lastName; 
	}
}
