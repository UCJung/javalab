package com.mykumi.springlab.exam.service;

import static com.mykumi.springlab.exam.service.UserServiceImpl.MIN_LOGINCOUNT_FOR_SILVER;
import static com.mykumi.springlab.exam.service.UserServiceImpl.MIN_RECOMMEND_FOR_GOLD;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.fail;
import static org.mockito.Mockito.*;

import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.PlatformTransactionManager;

import com.mykumi.springlab.exam.Level;
import com.mykumi.springlab.exam.User;
import com.mykumi.springlab.exam.UserBuilder;
import com.mykumi.springlab.exam.UserBuilderTypeA;
import com.mykumi.springlab.exam.UserDao;
import com.mykumi.springlab.exam.service.TestUserService.TestUserServiceException;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "/com/mykumi/springlab/exam/service/applicationContext.xml")
public class UserServiceTest {
	@Autowired
	ApplicationContext context;
	
	@Autowired
	UserService userService;
	
	@Autowired
	UserServiceImpl userServiceImpl;

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
	public void  mockUpgradeLevels() throws Exception {
		UserServiceImpl userServiceImpl = new UserServiceImpl();
		
		UserDao mockUserDao = mock(UserDao.class);
		when(mockUserDao.getAll()).thenReturn(this.users);
		userServiceImpl.setUserDao(mockUserDao);
		
		MailSender mockMailSender = mock(MailSender.class);
		userServiceImpl.setMailSender(mockMailSender);

		userServiceImpl.upgradeLevels();
		
		verify(mockUserDao, times(2)).update(any(User.class));
		verify(mockUserDao).update(users.get(1));
		assertThat(users.get(1).getLevel(),is(Level.SILVER));
		verify(mockUserDao).update(users.get(3));
		assertThat(users.get(3).getLevel(),is(Level.GOLD));
		
		ArgumentCaptor<SimpleMailMessage> mailMessageArg = ArgumentCaptor.forClass(SimpleMailMessage.class);
		
		verify(mockMailSender, times(2)).send(mailMessageArg.capture());
		List<SimpleMailMessage> mailMessages = mailMessageArg.getAllValues();
		assertThat(mailMessages.get(0).getTo()[0], is(users.get(1).getEmail()));
		assertThat(mailMessages.get(1).getTo()[0], is(users.get(3).getEmail()));
	}
	
	@Test
	@DirtiesContext
	public void ugradeLevels() throws Exception {
		UserServiceImpl userServiceImpl = new UserServiceImpl();
		
		MockUserDao mockUserDao = new MockUserDao(this.users);
		userServiceImpl.setUserDao(mockUserDao);
		
		MockMailSender mockMailSender = new MockMailSender();
		userServiceImpl.setMailSender(mockMailSender);

		userServiceImpl.upgradeLevels();
		
		List<User> updated = mockUserDao.getUpdated();  
		
		assertThat(updated.size(), is(2));
		checkUserAndLevel(updated.get(0), "user2", Level.SILVER);
		checkUserAndLevel(updated.get(1), "user4", Level.GOLD);
		
		List<String> requests = mockMailSender.getRequests();
		assertThat(requests.size(), is(2));
		assertThat(requests.get(0), is(users.get(1).getEmail()));
		assertThat(requests.get(1), is(users.get(3).getEmail()));
	}

	private void checkUserAndLevel(User updated, String expectedId, Level expectedLevel) {
		assertThat(updated.getId(), is(expectedId));
		assertThat(updated.getLevel(), is(expectedLevel));
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
	@DirtiesContext
	public void upgradeAllOrNothing() throws Exception {
		TestUserService testUserService = new TestUserService(users.get(3).getId());
		testUserService.setUserDao(this.userDao);
		testUserService.setMailSender(mailSender);
		
		TxProxyFactoryBean txProxyFactoryBean = context.getBean("&userService", TxProxyFactoryBean.class);
		txProxyFactoryBean.setTarget(testUserService);
		
		UserService txUserService = (UserService) txProxyFactoryBean.getObject();

		userDao.deleteAll();

		for (User user : users)
			userDao.add(user);

		try {
			txUserService.upgradeLevels();
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
	
	static class MockUserDao implements UserDao {
		private List<User> users;	// level upgrade 후보 User Object list
		private List<User> updated = new ArrayList();
		
		private MockUserDao(List<User> users) {
			this.users = users;
		}
		
		public List<User> getUpdated() {
			return this.updated;
		}
		
		@Override
		public List<User> getAll() {
			return this.users;
		}

		@Override
		public void update(User user) {
			this.updated.add(user);
		}
		
		
		@Override
		public void add(User user) throws DuplicateKeyException {
			throw new UnsupportedOperationException();
		}

		@Override
		public User get(String id) {
			throw new UnsupportedOperationException();
		}

		@Override
		public void deleteAll() {
			throw new UnsupportedOperationException();
		}

		@Override
		public int getCount() {
			throw new UnsupportedOperationException();
		}

	}
}
