package com.divergentsl.cms.databaseconnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Repository;

/**
 * Class for DatabaseManager for database connection
 * 
 * @author Pooja Patidar
 *
 */
@Repository
public class DatabaseManager implements IDatabaseManager {
	
	@Autowired
	Environment en;
	

	static {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			System.out.println(e);
			System.exit(0);
		}

	}

	public Connection getConnection() throws SQLException {
		return DriverManager.getConnection(en.getProperty(url), en.getProperty(username), en.getProperty(password));
	}

}
