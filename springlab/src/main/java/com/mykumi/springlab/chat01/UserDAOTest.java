package com.mykumi.springlab.chat01;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.List;

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
	public void getAllTest() {
		userDao.deleteAll();
		
		// 데이타가 없을때에 대한 테스트 케이스 작성
		List<User> users = userDao.getAll();
		users = userDao.getAll();
		assertThat(users.size(), is(0));
		
		User user1 = new User("u1", "user01", "111111");
		userDao.add(user1);
		users = userDao.getAll();
		assertThat(users.size(), is(1));
		this.checkSameUser(user1, users.get(0));

		User user2 = new User("u2", "user02", "222222");
		userDao.add(user2);
		users = userDao.getAll();
		assertThat(users.size(), is(2));
		this.checkSameUser(user1, users.get(0));
		this.checkSameUser(user2, users.get(1));
		
		User user3 = new User("u3", "user03", "333333");
		userDao.add(user3);
		users = userDao.getAll();
		assertThat(users.size(), is(3));
		this.checkSameUser(user1, users.get(0));
		this.checkSameUser(user2, users.get(1));
		this.checkSameUser(user3, users.get(2));
	}
	@Test
	public void addAndGet() {
		userDao.deleteAll();
		assertThat(userDao.getCount(), is(0));
		
		User user = new User("mykumi", "UC JUNG", "111111");

		userDao.add(user);
		assertThat(userDao.getCount(), is(1));
		
		User user2 = userDao.get(user.getId());
		
		checkSameUser(user, user2);
	}
	
	@Test 
	public void getCount() {
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
	public void getFailure() {
		userDao.deleteAll();
		assertThat(userDao.getCount(), is(0));
		
		userDao.get("unknown_id");
	}
	
	private void checkSameUser(User user, User user2) {
		assertThat(user.getId(), is(user2.getId()));
		assertThat(user.getName(), is(user2.getName()));
		assertThat(user.getPassword(), is(user2.getPassword()));
	}
}
