package com.mykumi.designpattern.decorator;

public interface IComponent {

	public abstract void setFirstName(String firstName);

	public abstract void setLastName(String lastName);

	public abstract String getWelcomeMessage();

}