package com.mykumi.springlab.chat01;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="/com/mykumi/springlab/chat01/applicationContext.xml")
public class UserDAOTest {
	@Autowired
	private UserDAO userDao;

	@Test
	public void addAndGet() throws SQLException {
		userDao.deleteAll();
		assertThat(userDao.getCount(), is(0));
		
		User user = new User("mykumi", "UC JUNG", "111111");

		userDao.add(user);
		assertThat(userDao.getCount(), is(1));
		
		User user2 = userDao.get(user.getId());
		
		assertThat(user.getName(), is(user2.getName()));
		assertThat(user.getPassword(), is(user2.getPassword()));
	}

	@Test 
	public void getCount() throws SQLException {
		userDao.deleteAll();
		assertThat(userDao.getCount(), is(0));
		
		userDao.add(new User("u1", "user01", "111111"));
		assertThat(userDao.getCount(), is(1));
		
		userDao.add(new User("u2", "user02", "222222"));
		assertThat(userDao.getCount(), is(2));
		
		userDao.add(new User("u3", "user03", "333333"));
		assertThat(userDao.getCount(), is(3));
	}
	
	@Test(expected=EmptyResultDataAccessException.class)
	public void getFailure() throws SQLException {
		userDao.deleteAll();
		assertThat(userDao.getCount(), is(0));
		
		userDao.get("unknown_id");
	}
}
