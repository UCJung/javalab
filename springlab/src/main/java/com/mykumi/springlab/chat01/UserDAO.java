package com.mykumi.springlab.chat01;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLClientInfoException;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.dao.EmptyResultDataAccessException;

public class UserDAO {
	private DataSource dataSource;
	
	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}
	
	public void add(User user) throws SQLException {
		Connection dbConnection = dataSource.getConnection();
		PreparedStatement ps = dbConnection.prepareStatement(
				"INSERT INTO users(id, name, password) VALUES(?,?,?)"
				);
		ps.setString(1, user.getId());
		ps.setString(2, user.getName());
		ps.setString(3, user.getPassword());
		
		ps.executeUpdate();
		
		ps.close();
		dbConnection.close();
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
		StatementStrategy st = new DeleteAllStatementStrategy();
		jdbcContextWithStatementStrategy(st);
	}

	public int getCount() throws SQLException {
		Connection dbConnection = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			dbConnection = dataSource.getConnection();
			ps = dbConnection.prepareStatement(
					"SELECT COUNT(1) FROM users");
			rs = ps.executeQuery();
			rs.next();
			return rs.getInt(1);
		} catch (SQLException e) {
			throw e;
		} finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
				}
			}				
			if (ps != null) {
				try {
					ps.close();
				} catch (SQLException e) {
				}
			}		
			if (dbConnection != null) {
				try {
					dbConnection.close();
				} catch (SQLException e) {
				}
			}			
		}
	}

	public void jdbcContextWithStatementStrategy(StatementStrategy stmt) throws SQLException {
		Connection dbConnection = null;
		PreparedStatement ps = null;
		
		try {
			dbConnection = dataSource.getConnection();
			ps = stmt.makePreparedStatement(dbConnection);
			ps.executeUpdate();
			
		} catch (SQLException e) {
			throw e;
		} finally {
			if (ps != null) {
				try {
					ps.close();
				} catch (SQLException e) {
				}
			}		
			if (dbConnection != null) {
				try {
					dbConnection.close();
				} catch (SQLException e) {
				}
			}
		}
	}	
}