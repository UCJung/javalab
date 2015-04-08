package com.mykumi.springlab.chat01;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DaoFactory {
	@Bean
	public UserDAO userDao() {
		return new UserDAO(connectionMaker());
	}

	@Bean
	public ConnectionMaker connectionMaker() {
		ConnectionMaker connectionMaker = new NConnectionMaker();
		return connectionMaker;
	}
}
