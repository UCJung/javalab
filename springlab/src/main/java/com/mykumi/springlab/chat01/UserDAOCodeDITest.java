package com.mykumi.springlab.chat01;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.SingleConnectionDataSource;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="/com/mykumi/springlab/chat01/applicationContext.xml")
public class UserDAOCodeDITest {
	@Autowired
	private UserDAOJdbc userDao;
	
	@Autowired
	private JdbcContext jdbcContext;	

	@Before
	public void setUp() {

	}
	
	@Test
	@DirtiesContext
	public void addAndGet() throws SQLException {
		DataSource dataSource = new SingleConnectionDataSource(
				"jdbc:mysql://54.64.47.206/mykumitestdb","dbuser", "dbuser1*",true);
		jdbcContext.setDataSource(dataSource);
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		userDao.setJdbcTemplate(jdbcTemplate);
		
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
		//userDao.deleteAll();
		//assertThat(userDao.getCount(), is(0));
		
		userDao.get("unknown_id");
	}
}
