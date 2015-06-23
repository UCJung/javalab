package com.mykumi.springlab.exam;

import java.sql.ResultSet;
import java.sql.SQLException;

public interface ExtractStrategy {

	public abstract <T> T extractResult(ResultSet rs) throws SQLException;

}