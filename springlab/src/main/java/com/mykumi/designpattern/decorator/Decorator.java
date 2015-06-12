package com.mykumi.designpattern.decorator;

public abstract class Decorator implements IComponent {

	protected IComponent iComponent;
	
	public Decorator() {
		// TODO Auto-generated constructor stub
	}
	
	public Decorator(IComponent iComponent) {
		this.iComponent = iComponent;
	}
	
	public void setIComponent(IComponent iComponent) {
		this.iComponent = iComponent;
	}

	public abstract String getWelcomeMessage();

	public void setFirstName(String firstName) {
		iComponent.setFirstName(firstName);
	}

	public void setLastName(String lastName) {
		iComponent.setLastName(lastName);
	}
}