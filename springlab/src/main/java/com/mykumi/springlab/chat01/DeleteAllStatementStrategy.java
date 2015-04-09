package com.mykumi.springlab.chat01;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DeleteAllStatementStrategy implements StatementStrategy {

	@Override
	public PreparedStatement makePreparedStatement(Connection dbConnection)
			throws SQLException {
				
		return dbConnection.prepareStatement(
				"DELETE FROM users"
				);
	}

}
