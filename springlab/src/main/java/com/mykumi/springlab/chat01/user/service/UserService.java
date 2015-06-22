package com.mykumi.springlab.chat01.user.service;

import java.util.List;

import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;

import com.mykumi.springlab.chat01.Level;
import com.mykumi.springlab.chat01.User;
import com.mykumi.springlab.chat01.UserDao;

public class UserService {
	public static final int MIN_RECOMMEND_FOR_GOLD = 30;
	public static final int MIN_LOGINCOUNT_FOR_SILVER = 50;
	private UserDao userDao;
	private PlatformTransactionManager transactionManager;

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	public void setTransactionManager(
			PlatformTransactionManager transactionManager) {
		this.transactionManager = transactionManager;
	}

	public void upgradeLevels() throws Exception {
		TransactionStatus status = this.transactionManager
				.getTransaction(new DefaultTransactionDefinition());

		try {
			List<User> users = userDao.getAll();

			for (User user : users) {
				if (this.canUpgradeLevel(user) == true) {
					this.upgradeLevel(user);
				}
			}

			this.transactionManager.commit(status);
		} catch (Exception e) {
			this.transactionManager.rollback(status);
			throw e;
		}
	}

	protected boolean canUpgradeLevel(User user) {
		Level currentLevel = user.getLevel();
		switch (currentLevel) {
		case BASIC:
			return (user.getLogin() >= MIN_LOGINCOUNT_FOR_SILVER);
		case SILVER:
			return (user.getRecommend() >= MIN_RECOMMEND_FOR_GOLD);
		case GOLD:
			return false;
		default:
			throw new IllegalArgumentException("Unknown Level : "
					+ currentLevel);
		}
	}

	protected void upgradeLevel(User user) {
		user.upgradeLevel();
		userDao.update(user);
	}

	// 레벨이 설정되어 있지 않은 경우 BASIC 레벨로 설정한다.
	public void add(User user) {
		if (user.getLevel() == null)
			user.setLevel(Level.BASIC);
		userDao.add(user);
	}
}
