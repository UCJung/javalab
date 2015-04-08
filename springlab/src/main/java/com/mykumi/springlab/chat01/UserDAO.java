package com.mykumi.springlab.chat01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDAO {
	public void add(User user) throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.jdbc.Driver");
		Connection dbConnection = DriverManager.getConnection(
				"jdbc:mysql://54.64.47.206/mykumidb", 
				"dbuser", 
				"dbuser1*");
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
	
	public User get(String id) throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.jdbc.Driver");
		Connection dbConnection = DriverManager.getConnection(
				"jdbc:mysql://54.64.47.206/mykumidb", 
				"dbuser", 
				"dbuser1*");
		PreparedStatement ps = dbConnection.prepareStatement(
				"SELECT id, name, password FROM users WHERE id = ?"
				);
		
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
}
