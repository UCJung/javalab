package com.mykumi.springlab.chat01;

import java.sql.SQLException;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class UserDAOTest {

	public static void main(String[] args) throws SQLException {
		ApplicationContext context = new GenericXmlApplicationContext("/com/mykumi/springlab/chat01/applicationContext.xml");
		UserDAO userDao = context.getBean("userDao", UserDAO.class);
		
		User user = new User("mykumi", "UC JUNG");
		user.setPassword("111111");
		userDao.add(user);
		System.out.println(user.getId() + " success adding");
		
		User user2 = userDao.get(user.getId());
		if (!user.getName().equals(user2.getName())){
			System.out.println("Fail Test (name)");
		} 
		else if (!user.getPassword().equals(user2.getPassword())) {
			System.out.println("Fail Test (password)");
		}
		else {
			System.out.println(user2.getId() + " success getting");
		}
	}
}
