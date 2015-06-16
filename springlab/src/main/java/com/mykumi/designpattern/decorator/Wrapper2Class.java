package com.mykumi.designpattern.decorator;

public class Wrapper2Class extends Decorator {

	public Wrapper2Class(){
		super();
	}
	
	public Wrapper2Class(IComponent iComponent) {
		super(iComponent);
	}

	public String getWelcomeMessage() {
		String result = "How are You!";
		result = result + iComponent.getWelcomeMessage();
		return result;
	}
}
