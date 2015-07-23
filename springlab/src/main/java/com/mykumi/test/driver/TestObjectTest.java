package com.mykumi.test.driver;

import static org.junit.Assert.*;

import org.junit.Test;
import static org.hamcrest.CoreMatchers.*;

public class TestObjectTest {

	@Test
	public final void testAppend() {
		TestObject testObject = new TestObject();
		
		testObject.setAppender("Test");
		testObject.setAppendee("Driver");
		
		assertThat(testObject.append(), is("TestDriver"));
	}

}
