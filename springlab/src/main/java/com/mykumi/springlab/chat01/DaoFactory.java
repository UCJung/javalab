package com.mykumi.springlab.chat01;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DaoFactory {
	@Bean
	public UserDAO userDao() {
		UserDAO userDAO = new UserDAO();
		userDAO.setConnectionMaker(connectionMaker());
		return userDAO;
	}

	@Bean
	public ConnectionMaker connectionMaker() {
		ConnectionMaker connectionMaker = new NConnectionMaker();
		return connectionMaker;
	}
}
