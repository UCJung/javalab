package com.mykumi.springlab.chat01;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public interface StatementStrategy {

	public abstract PreparedStatement makePreparedStatement(
			Connection dbConnection) throws SQLException;

}