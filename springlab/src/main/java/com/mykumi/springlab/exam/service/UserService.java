package com.mykumi.springlab.exam.service;

import com.mykumi.springlab.exam.User;

public interface UserService {

	public abstract void upgradeLevels();

	// 레벨이 설정되어 있지 않은 경우 BASIC 레벨로 설정한다.
	public abstract void add(User user);

}