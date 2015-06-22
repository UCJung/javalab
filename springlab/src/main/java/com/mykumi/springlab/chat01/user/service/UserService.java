package com.mykumi.springlab.chat01.user.service;

import java.util.List;

import com.mykumi.springlab.chat01.Level;
import com.mykumi.springlab.chat01.User;
import com.mykumi.springlab.chat01.UserDao;

public class UserService {
	public static final int MIN_RECOMMEND_FOR_GOLD = 30;
	public static final int MIN_LOGINCOUNT_FOR_SILVER = 50;
	public UserDao userDao;
	
	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}
	
	public void upgradeLevels() {
		List<User> users = userDao.getAll();
		
		for (User user : users) {
			if (this.canUpgradeLevel(user) == true) {
				this.upgradeLevel(user);
			}
		}
	}
	
	private boolean canUpgradeLevel(User user) {
		Level currentLevel = user.getLevel();
		switch (currentLevel) {
			case BASIC : return (user.getLogin() >= MIN_LOGINCOUNT_FOR_SILVER);
			case SILVER : return (user.getRecommend() >= MIN_RECOMMEND_FOR_GOLD);
			case GOLD : return false;
			default: throw new IllegalArgumentException("Unknown Level : " + currentLevel);
		}
	}
	
	private void upgradeLevel(User user) {
		user.upgradeLevel();
		userDao.update(user);
	}
	
	// 레벨이 설정되어 있지 않은 경우 BASIC 레벨로 설정한다.
	public void add(User user) {
		if (user.getLevel() == null) user.setLevel(Level.BASIC);
		userDao.add(user);
	}
}
