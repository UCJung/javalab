package com.mykumi.springlab.exam;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public interface StatementStrategy {

	public abstract PreparedStatement makePreparedStatement(
			Connection dbConnection) throws SQLException;

}