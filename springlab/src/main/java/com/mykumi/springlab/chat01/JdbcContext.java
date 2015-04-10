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
	
	public void excuteSql(final String query) throws SQLException {
		workWithStatementStrategy(new StatementStrategy() {
			public PreparedStatement makePreparedStatement(Connection dbConnection)
					throws SQLException {
				return dbConnection.prepareStatement(query);
			}		
		});
	}	
	
	public void excuteSql(final String query, final String... params) throws SQLException {
		workWithStatementStrategy(new StatementStrategy(){
			public PreparedStatement makePreparedStatement(Connection dbConnection)
					throws SQLException {
				return setParams(dbConnection.prepareStatement(query), params);
			}
			private PreparedStatement setParams(PreparedStatement ps, final String[] params)
					throws SQLException {
				int i = 0;
				for (String param : params) {
					ps.setString(++i, param);
				}
				return ps;
			}
		});
	}	
}
