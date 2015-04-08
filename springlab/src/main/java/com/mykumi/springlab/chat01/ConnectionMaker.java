package com.mykumi.springlab.chat01;

import java.sql.Connection;
import java.sql.SQLException;

public interface ConnectionMaker {

	public abstract Connection makeNewConnection()
			throws ClassNotFoundException, SQLException;

}