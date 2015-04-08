package com.mykumi.springlab.chat01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

@Deprecated
public class SimpleConnectionMaker implements ConnectionMaker {
	/* (non-Javadoc)
	 * @see com.mykumi.springlab.chat01.ConnectionMaker#makeNewConnection()
	 */
	@Override
	public Connection makeNewConnection() throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.jdbc.Driver");
		Connection dbConnection = DriverManager.getConnection(
				"jdbc:mysql://54.64.47.206/mykumidb", 
				"dbuser", 
				"dbuser1*");
		return dbConnection;
	}
}
