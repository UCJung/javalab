package com.mykumi.springlab.chat01;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

import org.junit.Test;

import java.sql.SQLException;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class UserDAOTest {

	@Test
	public void addAndGet() throws SQLException {
		ApplicationContext context = new GenericXmlApplicationContext("/com/mykumi/springlab/chat01/applicationContext.xml");
		UserDAO userDao = context.getBean("userDao", UserDAO.class);
		
		User user = new User("mykumi", "UC JUNG");
		user.setPassword("111111");

		userDao.add(user);
		
		User user2 = userDao.get(user.getId());
		
		assertThat(user.getName(), is(user2.getName()));
		assertThat(user.getPassword(), is(user2.getPassword()));
	}
}
