package com.mykumi.springlab.chat01.user.service;

import com.mykumi.springlab.chat01.User;

public class TestUserService extends UserServiceImpl {
	private String id;

	public TestUserService(String id) {
		this.id = id;
	}

	protected void upgradeLevel(User user) throws TestUserServiceException {
		if (user.getId().equals(this.id))
			throw new TestUserServiceException();
		super.upgradeLevel(user);

	}

	static class TestUserServiceException extends RuntimeException {

		private static final long serialVersionUID = -8789534723187229873L;

	}
}
