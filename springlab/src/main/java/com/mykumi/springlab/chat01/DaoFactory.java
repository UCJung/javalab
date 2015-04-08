package com.mykumi.springlab.chat01;

public class DaoFactory {
	public UserDAO userDao() {
		return new UserDAO(connectionMaker());
	}

	private ConnectionMaker connectionMaker() {
		ConnectionMaker connectionMaker = new NConnectionMaker();
		return connectionMaker;
	}
}
