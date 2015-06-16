package com.mykumi.designpattern.decorator;

public class ClientWrapper {

	public static void main(String[] args) {
		IComponent addDeco = new Wrapper2Class(new WrapperClass(new OrignalClass()));
		addDeco.setFirstName("Woo Chul");
		addDeco.setLastName("Jung");
		System.out.println(addDeco.getWelcomeMessage());
	}

}
