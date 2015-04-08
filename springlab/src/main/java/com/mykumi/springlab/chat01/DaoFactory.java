package com.mykumi.springlab.chat01;

import javax.sql.DataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.SimpleDriverDataSource;

@Configuration
public class DaoFactory {
	@Bean
	public UserDAO userDao() {
		UserDAO userDAO = new UserDAO();
		userDAO.setDataSource(dataSource());
		return userDAO;
	}

	@Bean
	public DataSource dataSource() {
		SimpleDriverDataSource dataSource = new SimpleDriverDataSource();
		dataSource.setDriverClass(com.mysql.jdbc.Driver.class);
		dataSource.setUrl("jdbc:mysql://54.64.47.206/mykumidb");
		dataSource.setUsername("dbuser");
		dataSource.setPassword("dbuser1*");
		
		return dataSource;
	}
}
