package com.mykumi.springlab.exam.dynamicproxy;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

import org.junit.Test;

public class HelloTest {

	@Test
	public void test() {
		Hello hello = new HelloTarget();
		
		assertThat(hello.sayHello("Jung"),is("Hello Jung"));
		assertThat(hello.sayHi("Jung"),is("Hi Jung"));
		assertThat(hello.sayThankYou("Jung"),is("Thank you Jung"));
	}

}
