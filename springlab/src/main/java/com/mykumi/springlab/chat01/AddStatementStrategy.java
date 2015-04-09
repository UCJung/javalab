package com.mykumi.springlab.chat01;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class AddStatementStrategy implements StatementStrategy {
	private User user;
	
	public AddStatementStrategy(User user) {
		this.user = user;
	}

	@Override
	public PreparedStatement makePreparedStatement(Connection dbConnection)
			throws SQLException {
		PreparedStatement ps = dbConnection.prepareStatement(
				"INSERT INTO users(id, name, password) VALUES(?,?,?)"
				);
		ps.setString(1, user.getId());
		ps.setString(2, user.getName());
		ps.setString(3, user.getPassword());
		
		return ps;
	}

}
