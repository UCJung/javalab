package com.mykumi.designpattern.decorator;

public class OrignalClass implements IComponent {
	private String firstName;
	private String lastName;
	
	@Override
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	@Override
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	@Override
	public String getWelcomeMessage() {
		return "Welcome.. " + this.getName();
	}
	
	private String getName() {
		return this.firstName + " " + this.lastName; 
	}
}
