package com.divergentsl.cms.databaseconnection;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * Interface for database connection
 * 
 * @author Pooja Patidar
 *
 */
public interface IDatabaseManager {
	
	String username = "spring.datasource.username";
	
	String password = "spring.datasource.password";
	
	String url = "spring.datasource.url";
	
	public Connection getConnection() throws SQLException;
	
	

}
