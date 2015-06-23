package com.mykumi.springlab.exam;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="/com/mykumi/springlab/exam/applicationContext.xml")
public class UserDaoTest {
	@Autowired
	private UserDao userDao;
	
	private User user1;
	private User user2;
	private User user3;
	
	@Before
	public void setup() {
		UserBuilder builder1 = new UserBuilderTypeA();
		UserBuilder builder2 = new UserBuilderTypeB();
		
		this.user1 = builder1.id("u1")
				.name("user01")
				.password("111111")
				.level(Level.BASIC)
				.login(0)
				.recommend(1)
				.email("mykumi1@gmail.com")
				.build();
		this.user2 = builder2.id("u2")
				.name("user02")
				.password("222222")
				.level(Level.SILVER)
				.login(55)				
				.recommend(10)
				.email("mykumi2@gmail.com")
				.build();
		this.user3 = builder1.id("u3")
				.name("user03")
				.password("33333")
				.level(Level.GOLD)
				.login(100)
				.recommend(40)
				.email("mykumi3@gmail.com")
				.build();		
	}

	@Test
	public void getAllTest() {
		userDao.deleteAll();
		
		// 데이타가 없을때에 대한 테스트 케이스 작성
		List<User> users = userDao.getAll();
		users = userDao.getAll();
		assertThat(users.size(), is(0));
		
		userDao.add(user1);
		users = userDao.getAll();
		assertThat(users.size(), is(1));
		this.checkSameUser(user1, users.get(0));

		userDao.add(user2);
		users = userDao.getAll();
		assertThat(users.size(), is(2));
		this.checkSameUser(user1, users.get(0));
		this.checkSameUser(user2, users.get(1));
		
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
		
		userDao.add(user1);
		assertThat(userDao.getCount(), is(1));
		
		User getUser = userDao.get(user1.getId());
		
		checkSameUser(getUser, user1);
	}
	
	@Test 
	public void getCount() {
		userDao.deleteAll();
		assertThat(userDao.getCount(), is(0));
		
		userDao.add(user1);
		assertThat(userDao.getCount(), is(1));
		
		userDao.add(user2);
		assertThat(userDao.getCount(), is(2));
		
		userDao.add(user3);
		assertThat(userDao.getCount(), is(3));
	}
	
	@Test
	public void updateUser() {
		userDao.deleteAll();
		
		userDao.add(user1);
		userDao.add(user2);
		
		user1.setName("user01_c");
		user1.setPassword("1c");
		user1.setLevel(Level.GOLD);
		user1.setLogin(1000);
		user1.setRecommend(999);
		
		userDao.update(user1);
		
		User user1update = userDao.get(user1.getId());
		checkSameUser(user1, user1update);
		
		User user2same = userDao.get(user2.getId());
		checkSameUser(user2, user2same);		
	}
	
	@Test(expected=EmptyResultDataAccessException.class)
	public void getFailure() {
		userDao.deleteAll();
		assertThat(userDao.getCount(), is(0));
		
		userDao.get("unknown_id");
	}
	
	@Test(expected=DuplicateUserIdException.class)
	public void addDuplicateUser() {
		userDao.deleteAll();
		assertThat(userDao.getCount(), is(0));
		
		userDao.add(user1);
		assertThat(userDao.getCount(), is(1));
		
		userDao.add(user1);
	}	
	
	private void checkSameUser(User user, User user2) {
		assertThat(user.getId(), is(user2.getId()));
		assertThat(user.getName(), is(user2.getName()));
		assertThat(user.getPassword(), is(user2.getPassword()));
		assertThat(user.getLevel(), is(user2.getLevel()));
		assertThat(user.getLogin(), is(user2.getLogin()));
		assertThat(user.getRecommend(), is(user2.getRecommend()));
		assertThat(user.getEmail(), is(user2.getEmail()));
	}
}
