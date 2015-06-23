package com.mykumi.springlab.exam.dynamicproxy;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

public class UppercaseAdvice implements MethodInterceptor {

	@Override
	public Object invoke(MethodInvocation invocation) throws Throwable {
		String ret = (String)invocation.proceed();
		return ret.toUpperCase();
	}

}
