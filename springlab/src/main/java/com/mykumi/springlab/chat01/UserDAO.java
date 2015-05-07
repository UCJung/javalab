package com.mykumi.springlab.chat01;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.dao.DuplicateKeyException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

public class UserDAO {
	private class UserRowMapper implements RowMapper<User> {
		public User mapRow(ResultSet rs, int rowNum)
				throws SQLException {
			return new User(
					rs.getString("id"), 
					rs.getString("name"),
					rs.getString("password"));
		}
	}

	private JdbcTemplate jdbcTemplate;
	
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	
	public void add(final User user) throws DuplicateKeyException {
		try {
			this.jdbcTemplate.update("INSERT INTO users(id, name, password) VALUES(?,?,?)", 
					user.getId(),
					user.getName(),
					user.getPassword());			
		} catch (DuplicateKeyException e) {
			throw new DuplicateUserIdException(e);
		}
	}

	public User get(String id) {
		return this.jdbcTemplate.queryForObject("SELECT id, name, password FROM users WHERE id = ?", 
				new Object[] {id},
				new UserRowMapper());
	}
	
	public void deleteAll() {
		this.jdbcTemplate.update("DELETE FROM users");
	}

	public int getCount() {
		return this.jdbcTemplate.queryForObject("SELECT COUNT(1) FROM users", Integer.class);
	}

	public List<User> getAll() {
		return this.jdbcTemplate.query("SELECT * FROM users order by id",
				new UserRowMapper());
	}
}