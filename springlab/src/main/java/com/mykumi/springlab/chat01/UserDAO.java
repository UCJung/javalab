package com.mykumi.springlab.chat01;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.dao.EmptyResultDataAccessException;

public class UserDAO {
	private DataSource dataSource;
	private JdbcContext jdbcContext;
	
	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}
	
	public void setJdbcContext(JdbcContext jdbcContext) {
		this.jdbcContext = jdbcContext;
	}
	
	public void add(final User user) throws SQLException {
		this.jdbcContext.excuteUpdateSql("INSERT INTO users(id, name, password) VALUES(?,?,?)",
				user.getId(),
				user.getName(),
				user.getPassword());
	}

	public User get(String id) throws SQLException {
		Connection dbConnection = dataSource.getConnection();
		PreparedStatement ps = dbConnection.prepareStatement(
				"SELECT id, name, password FROM users WHERE id = ?"
				);
		ps.setString(1, id);
		
		ResultSet rs = ps.executeQuery();
		
		User user = null;
		if (rs.next()) {
			user = new User(
					rs.getString("id"), 
					rs.getString("name"),
					rs.getString("password"));
		}
		
		rs.close();
		ps.close();
		dbConnection.close();
		
		if (user == null) {
			throw new EmptyResultDataAccessException(1);
		}
		return user;
	}
	
	public void deleteAll() throws SQLException {
		this.jdbcContext.excuteUpdateSql("DELETE FROM users");
	}

	public int getCount() throws SQLException {
		return this.jdbcContext.executeSelectSql("SELECT COUNT(1) FROM users");
	}
}