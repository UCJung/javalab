package com.mykumi.springlab.chat01.user.service;

import com.mykumi.springlab.chat01.User;

public class TestUserService extends UserService {
	private String id;
	
	public TestUserService(String id) {
		this.id = id;
	}
	
	protected void upgradeLevel(User user) throws TestUserServiceException {
		if (user.getId().equals(this.id)) throw new TestUserServiceException();
		super.upgradeLevel(user);
		
	}
	
	static class TestUserServiceException extends RuntimeException {

	}	
}
