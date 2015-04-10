package com.mykumi.springlab.chat01;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.sql.DataSource;

public class JdbcContext {
	private DataSource dataSource;
	
	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	public void workWithStatementStrategy(StatementStrategy stmt) throws SQLException {
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
