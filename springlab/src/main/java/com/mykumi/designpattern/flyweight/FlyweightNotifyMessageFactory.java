package com.mykumi.designpattern.flyweight;

import java.util.HashMap;
import java.util.Map;

public class FlyweightNotifyMessageFactory {
	private Map<String, NotifyMessage> formatedNotifyMessages;
	
	public FlyweightNotifyMessageFactory() {
		formatedNotifyMessages = new HashMap<String, NotifyMessage>(); 
	}
	
	public NotifyMessage getFormatedNotifyMessage(String key) {
		if (!formatedNotifyMessages.containsKey(key)) {
			addFormatedNotifyMessages(key); 
		}
		return formatedNotifyMessages.get(key);
	}
	
	private void addFormatedNotifyMessages(String key) {
		formatedNotifyMessages.put(key, new FormatedNotifyMessage(key));
	}
}
