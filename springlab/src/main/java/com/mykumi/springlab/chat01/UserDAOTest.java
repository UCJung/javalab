package com.mykumi.springlab.chat01;

import java.sql.SQLException;

public class UserDAOTest {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		UserDAO userDao = new DaoFactory().userDao();
		
		User user = new User("mykumi", "UC JUNG");
		user.setPassword("111111");
		
		userDao.add(user);
		
		System.out.println(user.getId() + " success adding");
		
		User user2 = userDao.get(user.getId());
		System.out.println(user2.getId() + " success searching");
	}
}
