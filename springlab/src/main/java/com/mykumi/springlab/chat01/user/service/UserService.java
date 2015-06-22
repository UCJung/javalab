package com.mykumi.springlab.chat01.user.service;

import java.util.List;

import com.mykumi.springlab.chat01.Level;
import com.mykumi.springlab.chat01.User;
import com.mykumi.springlab.chat01.UserDao;

public class UserService {
	UserDao userDao;
	
	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}
	
	public void upgradeLevels() {
		List<User> users = userDao.getAll();
		
		for (User user : users) {
			Boolean changed = null;	// 레벨의 변화가 있는지 확인하는 플래그
			if (user.getLevel() == Level.BASIC && user.getLogin() >= 50) {
				user.setLevel(Level.SILVER);
				changed = true;
			}
			else if (user.getLevel() == Level.SILVER && user.getRecommend() >= 30) {
				user.setLevel(Level.GOLD);
				changed = true;
			}
			else if (user.getLevel() == Level.GOLD) {
				changed = false;
			}
			else {
				changed = false;
			}
			
			if (changed) {
				userDao.update(user);
			}
		}
	}

	// 레벨이 설정되어 있지 않은 경우 BASIC 레벨로 설정한다.
	public void add(User user) {
		if (user.getLevel() == null) user.setLevel(Level.BASIC);
		userDao.add(user);
	}
}
