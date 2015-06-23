package com.mykumi.springlab.exam.dynamicproxy;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

import org.junit.Test;

public class HelloTest {

	@Test
	public void test() {
		Hello hello = new HelloTarget();
		
		assertThat(hello.sayHello("Jung"),is("Hello Jung"));
		assertThat(hello.sayHi("Jung"),is("Hi Jung"));
		assertThat(hello.sayThankYou("Jung"),is("Thank you Jung"));
		
		Hello proxyHello = new HelloUppercase(hello);
		
		assertThat(proxyHello.sayHello("JUNG"),is("HELLO JUNG"));
		assertThat(proxyHello.sayHi("JUNG"),is("HI JUNG"));
		assertThat(proxyHello.sayThankYou("JUNG"),is("THANK YOU JUNG"));
		
		Hello dynimicProxyHello = (Hello)Proxy.newProxyInstance(
				getClass().getClassLoader(), 
				new Class[] { Hello.class }, 
				new UppercaseHandler(new HelloTarget()));
		
		assertThat(dynimicProxyHello.sayHello("JUNG"),is("HELLO JUNG"));
		assertThat(dynimicProxyHello.sayHi("JUNG"),is("HI JUNG"));
		assertThat(dynimicProxyHello.sayThankYou("JUNG"),is("THANK YOU JUNG"));
		
	}

}
