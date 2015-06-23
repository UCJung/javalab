package com.mykumi.springlab.exam.dynamicproxy;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

import org.junit.Test;
import org.springframework.aop.framework.ProxyFactoryBean;
import org.springframework.aop.support.DefaultPointcutAdvisor;
import org.springframework.aop.support.NameMatchMethodPointcut;

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
	
	@Test
	public void proxyFactoryBean() {
		ProxyFactoryBean pfBean = new ProxyFactoryBean();
		pfBean.setTarget(new HelloTarget());
		pfBean.addAdvice(new UppercaseAdvice());
		pfBean.setInterfaces(new Class[] { Hello.class }); // 생략해도 됨.
		
		Hello proxiedHandler = (Hello) pfBean.getObject();
		
		assertThat(proxiedHandler.sayHello("JUNG"),is("HELLO JUNG"));
		assertThat(proxiedHandler.sayHi("JUNG"),is("HI JUNG"));
		assertThat(proxiedHandler.sayThankYou("JUNG"),is("THANK YOU JUNG"));
	}
	
	@Test
	public void pointcutAdvisor() {
		ProxyFactoryBean pfBean = new ProxyFactoryBean();
		pfBean.setTarget(new HelloTarget());
		
		NameMatchMethodPointcut pointcut = new NameMatchMethodPointcut();
		pointcut.setMappedName("sayH*");
		
		pfBean.addAdvisor(new DefaultPointcutAdvisor(pointcut, new UppercaseAdvice()));
		
		Hello proxiedHello = (Hello) pfBean.getObject();
		
		assertThat(proxiedHello.sayHello("Jung"),is("HELLO JUNG"));
		assertThat(proxiedHello.sayHi("Jung"),is("HI JUNG"));
		assertThat(proxiedHello.sayThankYou("Jung"),is("Thank you Jung"));
	}
	

}
