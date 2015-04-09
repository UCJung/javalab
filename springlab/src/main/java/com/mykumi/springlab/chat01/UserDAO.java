package com.mykumi.springlab.chat01;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

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
		rs.next();
		
		User user = new User(
				rs.getString("id"), 
				rs.getString("name"));
		user.setPassword(rs.getString("password"));
		
		rs.close();
		ps.close();
		dbConnection.close();
		
		return user;
	}
	
	public void deleteAll() throws SQLException {
		Connection dbConnection = dataSource.getConnection();
		PreparedStatement ps = dbConnection.prepareStatement(
				"DELETE FROM users"
				);
		ps.executeUpdate();
		
		ps.close();
		dbConnection.close();
	}
	
	public int getCount() throws SQLException {
		Connection dbConnection = dataSource.getConnection();
		PreparedStatement ps = dbConnection.prepareStatement(
				"SELECT COUNT(1) FROM users");
		
		ResultSet rs = ps.executeQuery();
		rs.next();
		int count = rs.getInt(1);
		
		rs.close();
		ps.close();
		dbConnection.close();
		
		return count;
	}
}