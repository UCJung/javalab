package com.mykumi.springlab.chat01.user.service;

import static com.mykumi.springlab.chat01.user.service.UserService.MIN_LOGINCOUNT_FOR_SILVER;
import static com.mykumi.springlab.chat01.user.service.UserService.MIN_RECOMMEND_FOR_GOLD;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.fail;

import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.PlatformTransactionManager;

import com.mykumi.springlab.chat01.Level;
import com.mykumi.springlab.chat01.User;
import com.mykumi.springlab.chat01.UserBuilder;
import com.mykumi.springlab.chat01.UserBuilderTypeA;
import com.mykumi.springlab.chat01.UserDao;
import com.mykumi.springlab.chat01.user.service.TestUserService.TestUserServiceException;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "/com/mykumi/springlab/chat01/user/service/applicationContext.xml")
public class UserServiceTest {
	@Autowired
	UserService userService;

	@Autowired
	PlatformTransactionManager transactionManager;

	@Autowired
	UserDao userDao;
	
	@Autowired
	MailSender mailSender;

	List<User> users;

	@Before
	public void setUp() {
		UserBuilder userBuilder = new UserBuilderTypeA();
		users = Arrays.asList(
				userBuilder.id("user1").name("name1").password("u1")
						.level(Level.BASIC)
						.login(MIN_LOGINCOUNT_FOR_SILVER - 1)
						.recommend(0)
						.email("mykumi1@gmail.com")
						.build(),
				userBuilder.id("user2").name("name2").password("u2")
						.level(Level.BASIC)
						.login(MIN_LOGINCOUNT_FOR_SILVER)
						.recommend(0)
						.email("mykumi2@gmail.com")
						.build(),
				userBuilder.id("user3").name("name3").password("u3")
						.level(Level.SILVER)
						.login(60)
						.email("mykumi3@gmail.com")
						.recommend(MIN_RECOMMEND_FOR_GOLD - 1).build(),
				userBuilder.id("user4").name("name4").password("u4")
						.level(Level.SILVER).login(60)
						.recommend(MIN_RECOMMEND_FOR_GOLD)
						.email("mykumi4@gmail.com")
						.build(),
				userBuilder.id("user5").name("name5").password("u5")
						.level(Level.GOLD).login(100)
						.recommend(Integer.MAX_VALUE)
						.email("mykumi5@gmail.com")
						.build());
	}

	@Test
	public void bean() {
		assertThat(this.userService, is(notNullValue()));
	}

	@Test
	public void ugradeLevels() throws Exception {
		userDao.deleteAll();

		for (User user : users) {
			userDao.add(user);
		}

		userService.upgradeLevels();

		checkLevel(users.get(0), false);
		checkLevel(users.get(1), true);
		checkLevel(users.get(2), false);
		checkLevel(users.get(3), true);
		checkLevel(users.get(4), false);
	}

	@Test
	public void add() {
		userDao.deleteAll();

		User userWithLevel = users.get(4);
		User userWithoutLevel = users.get(0);
		userWithoutLevel.setLevel(null);

		userService.add(userWithLevel);
		userService.add(userWithoutLevel);

		User userWithLevelRead = userDao.get(userWithLevel.getId());
		User userWithoutLevelRead = userDao.get(userWithoutLevel.getId());

		assertThat(userWithLevelRead.getLevel(), is(userWithLevel.getLevel()));
		assertThat(userWithoutLevelRead.getLevel(), is(Level.BASIC));
	}

	@Test
	public void upgradeAllOrNothing() throws Exception {
		UserService testUserService = new TestUserService(users.get(3).getId());
		testUserService.setUserDao(this.userDao);
		testUserService.setTransactionManager(this.transactionManager);
		testUserService.setMailSender(mailSender);
		userDao.deleteAll();

		for (User user : users)
			userDao.add(user);

		try {
			testUserService.upgradeLevels();
			fail("TestUserServiceException expected");
		} catch (TestUserServiceException e) {
		}
		checkLevel(users.get(1), false); // 오류 이전에 Update 한 사용자의 Level이 바뀌었나 확인
	}

	private void checkLevel(User user, boolean upgraded) {
		User userUpdate = userDao.get(user.getId());
		if (upgraded) {
			assertThat(userUpdate.getLevel(), is(user.getLevel().nextLevel()));
		} else {
			assertThat(userUpdate.getLevel(), is(user.getLevel()));
		}
	}
}
