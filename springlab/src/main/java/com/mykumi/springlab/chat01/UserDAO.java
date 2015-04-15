package com.mykumi.springlab.chat01;

import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.dao.EmptyResultDataAccessException;

public class UserDAO {
	private JdbcContext jdbcContext;
	
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
		return this.jdbcContext.executeSelectSql("SELECT id, name, password FROM users WHERE id = ?", new ExtractStrategy() {
			@SuppressWarnings("unchecked")
			public <T> T extractResult(ResultSet rs) throws SQLException {
				User user = null;
				if (rs.next()) {
					user = new User(
						rs.getString("id"), 
						rs.getString("name"),
						rs.getString("password"));
				}
				if (user == null) {
					throw new EmptyResultDataAccessException(1);
				}					
				return (T) user;
			}
		}, id);		
	}
	
	public void deleteAll() throws SQLException {
		this.jdbcContext.excuteUpdateSql("DELETE FROM users");
	}

	public int getCount() throws SQLException {
		return this.jdbcContext.executeSelectSql("SELECT COUNT(1) FROM users", new ExtractStrategy() {
			@SuppressWarnings("unchecked")
			public <T> T extractResult(ResultSet rs) throws SQLException {
				rs.next();
				Integer result = rs.getInt(1); 
				return (T) result;
			}
		});
	}
}