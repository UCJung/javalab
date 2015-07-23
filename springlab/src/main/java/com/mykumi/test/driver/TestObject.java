package com.mykumi.test.driver;

public class TestObject {
	private String appender = "";
	private String appendee = "";
	
	public String append() {
		return (appender + appendee);
	}

	public String getAppender() {
		return appender;
	}

	public void setAppender(String appender) {
		this.appender = appender;
	}

	public String getAppendee() {
		return appendee;
	}

	public void setAppendee(String appendee) {
		this.appendee = appendee;
	}
}
