package com.mykumi.springlab.chat01;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.dao.DuplicateKeyException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

public class UserDAOJdbc implements UserDAO {
	private class UserRowMapper implements RowMapper<User> {
		public User mapRow(ResultSet rs, int rowNum)
				throws SQLException {
			UserBuilder builder = new UserBuilderTypeA();
			return builder.id(rs.getString("id"))
					.name(rs.getString("name"))
					.password(rs.getString("password"))
					.level(Level.valueOf(rs.getInt("level")))
					.login(rs.getInt("login"))
					.recommend(rs.getInt("recommend"))
					.build();
		}
	}

	private JdbcTemplate jdbcTemplate;
	
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	
	@Override
	public void add(final User user) throws DuplicateKeyException {
		try {
			this.jdbcTemplate.update("INSERT INTO users(id, name, password, level, login, recommend) VALUES(?,?,?,?,?,?)", 
					user.getId(),
					user.getName(),
					user.getPassword(),
					user.getLevel().intValue(),
					user.getLogin(),
					user.getRecommend());			
		} catch (DuplicateKeyException e) {
			throw new DuplicateUserIdException(e);
		}
	}

	@Override
	public User get(String id) {
		return this.jdbcTemplate.queryForObject("SELECT id, name, password, level, login, recommend  FROM users WHERE id = ?", 
				new Object[] {id},
				new UserRowMapper());
	}
	
	@Override
	public void deleteAll() {
		this.jdbcTemplate.update("DELETE FROM users");
	}

	@Override
	public int getCount() {
		return this.jdbcTemplate.queryForObject("SELECT COUNT(1) FROM users", Integer.class);
	}

	@Override
	public List<User> getAll() {
		return this.jdbcTemplate.query("SELECT id, name, password, level, login, recommend FROM users order by id",
				new UserRowMapper());
	}
}