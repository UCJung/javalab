package com.mykumi.springlab.chat01.user.service;

import com.mykumi.springlab.chat01.UserDao;

public class UserService {
	UserDao userDao;
	
	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}
}
