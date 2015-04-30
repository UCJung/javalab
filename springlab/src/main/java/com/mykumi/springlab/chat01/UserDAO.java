package com.mykumi.springlab.chat01;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

public class UserDAO {
	private JdbcContext jdbcContext;
	private JdbcTemplate jdbcTemplate;
	
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	
	public void setJdbcContext(JdbcContext jdbcContext) {
		this.jdbcContext = jdbcContext;
	}
	
	public void add(final User user) {
		this.jdbcTemplate.update("INSERT INTO users(id, name, password) VALUES(?,?,?)", 
				user.getId(),
				user.getName(),
				user.getPassword());
	}

	public User get(String id) {
		return this.jdbcTemplate.queryForObject("SELECT id, name, password FROM users WHERE id = ?", 
				new Object[] {id},
				new RowMapper<User>() {
					public User mapRow(ResultSet rs,
							int rowNum) throws SQLException {
						return new User(
								rs.getString("id"), 
								rs.getString("name"),
								rs.getString("password"));
					}
				});
	}
	
	public void deleteAll() {
		/* ProparedStatmentCreator를 사용하는 방식		
 		this.jdbcTemplate.update(new PreparedStatementCreator() {
			public PreparedStatement createPreparedStatement(Connection con)
					throws SQLException {
				return con.prepareStatement("DELETE FROM users");
			}
		});*/
		
		this.jdbcTemplate.update("DELETE FROM users");
	}

	public int getCount() throws SQLException {
		return this.jdbcTemplate.queryForObject("SELECT COUNT(1) FROM users", Integer.class);
	}
}