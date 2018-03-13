package com.revature.bank.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import com.revature.bank.util.ConnectionFactory;

public class LogDaoImpl implements LogDao{

	public Boolean storeLog(String log) {
		Connection conn = ConnectionFactory.getInstance().getConnection();
		
		try {
			Statement statement = conn.createStatement();
			
			String sql = "INSERT INTO TRANSACTION (TODAYS_TIME, LOG_STATEMENT)VALUES(CURRENT_TIMESTAMP, '" + log + "')";
			statement.executeUpdate(sql);
			conn.commit();
			return true;
		
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
}
