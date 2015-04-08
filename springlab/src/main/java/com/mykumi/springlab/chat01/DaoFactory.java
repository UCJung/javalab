package com.mykumi.springlab.chat01;

public class DaoFactory {
	public UserDAO userDao() {
		ConnectionMaker connectionMaker = new NConnectionMaker();
		UserDAO userDao = new UserDAO(connectionMaker);
		return userDao;
	}
}
