package com.mykumi.designpattern.flyweight;

import static org.junit.Assert.*;

import org.junit.Test;

public class FlyweightNotifyMessageFactoryTest {

	@Test
	public final void testFlyweightFactory() {
		FlyweightNotifyMessageFactory nmFactory = new FlyweightNotifyMessageFactory();		
		NotifyMessage welcomNotifyMessage = nmFactory.getFormatedNotifyMessage("welcome");
		NotifyMessage welcomNotifyMessage2 = nmFactory.getFormatedNotifyMessage("welcome");
		
		assertSame(welcomNotifyMessage, welcomNotifyMessage2);
	}
	
	@Test
	public void testNonFlyweightFaoctory() {
		NotifyMessage welcomNotifyMessage = new FormatedNotifyMessage("welcome");
		NotifyMessage welcomNotifyMessage2 = new FormatedNotifyMessage("welcome");
		
		assertNotSame(welcomNotifyMessage, welcomNotifyMessage2);
	}

}
