package com.mykumi.springlab.chat01.user.service;

import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;

import com.mykumi.springlab.chat01.User;

public class UserServiceTx implements UserService {
	UserService userService;
	private PlatformTransactionManager transactionManager;

	public void setTransactionManager(
			PlatformTransactionManager transactionManager) {
		this.transactionManager = transactionManager;
	}

	public void setUserService (UserService userService) {
		this.userService = userService;
	}
	
	@Override
	public void upgradeLevels() {
		TransactionStatus status = this.transactionManager
				.getTransaction(new DefaultTransactionDefinition());
		try {
			this.userService.upgradeLevels();
			this.transactionManager.commit(status);
		} catch (Exception e) {
			this.transactionManager.rollback(status);
			throw e;
		}
	}

	@Override
	public void add(User user) {
		this.userService.add(user);
	}

}
