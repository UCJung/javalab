package com.mykumi.springlab.exam;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.jdbc.core.SqlParameterValue;
import org.springframework.jdbc.core.SqlTypeValue;
import org.springframework.jdbc.core.StatementCreatorUtils;

public class JdbcContext {
	private DataSource dataSource;
	
	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	public void updateWithStatementStrategy(StatementStrategy stmt) throws SQLException {
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
	
	public <T> T selectWithStatementStrategy(StatementStrategy stmt, ExtractStrategy extract) throws SQLException {
		Connection dbConnection = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			dbConnection = dataSource.getConnection();
			ps = stmt.makePreparedStatement(dbConnection);
			rs = ps.executeQuery();
			return extract.extractResult(rs);
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

	public void excuteUpdateSql(final String query) throws SQLException {
		updateWithStatementStrategy(new StatementStrategy() {
			public PreparedStatement makePreparedStatement(Connection dbConnection)
					throws SQLException {
				return dbConnection.prepareStatement(query);
			}
		});
	}	
	
	public void excuteUpdateSql(final String query, final Object... params) throws SQLException {
		updateWithStatementStrategy(new StatementStrategy(){
			public PreparedStatement makePreparedStatement(Connection dbConnection)
					throws SQLException {
				return setParams(dbConnection.prepareStatement(query), params);
			}
			private PreparedStatement setParams(PreparedStatement ps, Object[] params)
					throws SQLException {
				for (int i = 0; i < params.length ; i ++) {
					Object param = params[i];
					if (param instanceof SqlParameterValue) {
						SqlParameterValue paramValue = (SqlParameterValue) param;
						StatementCreatorUtils.setParameterValue(ps, i + 1, paramValue, paramValue.getValue());
					}
					else {
						StatementCreatorUtils.setParameterValue(ps, i + 1, SqlTypeValue.TYPE_UNKNOWN, param);
					}					
				}
				return ps;
			}
		});
	}	
	
	public <T> T executeSelectSql(final String query, ExtractStrategy extract) throws SQLException {
		return selectWithStatementStrategy(new StatementStrategy() {
			public PreparedStatement makePreparedStatement(Connection dbConnection)
					throws SQLException {
				PreparedStatement ps = dbConnection.prepareStatement(query);
				return ps;
			}
		}, extract);
	}	
	public <T> T executeSelectSql(final String query, ExtractStrategy extract, final Object... params ) throws SQLException {
		return selectWithStatementStrategy(new StatementStrategy() {
			public PreparedStatement makePreparedStatement(Connection dbConnection)
					throws SQLException {
				return setParams(dbConnection.prepareStatement(query), params);
			}
			private PreparedStatement setParams(PreparedStatement ps, Object[] params)
					throws SQLException {
				for (int i = 0; i < params.length ; i ++) {
					Object param = params[i];
					if (param instanceof SqlParameterValue) {
						SqlParameterValue paramValue = (SqlParameterValue) param;
						StatementCreatorUtils.setParameterValue(ps, i + 1, paramValue, paramValue.getValue());
					}
					else {
						StatementCreatorUtils.setParameterValue(ps, i + 1, SqlTypeValue.TYPE_UNKNOWN, param);
					}					
				}
				return ps;
			}
		}, extract);
	}		
}
