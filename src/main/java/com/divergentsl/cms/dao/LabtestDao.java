package com.divergentsl.cms.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.divergentsl.cms.databaseconnection.IDatabaseManager;
import com.divergentsl.cms.dto.LabtestDto;

/**
 * 
 * Class for Labtest Dao
 * 
 * @author Pooja Patidar
 *
 */
@Repository
public class LabtestDao {
	
	/*
	 * @Autowired IDatabaseManager databaseManager;
	 */
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	private static Logger myLogger = LoggerFactory.getLogger(LabtestDao.class);
	
	/**
	 * This method insert the labtest
	 * @param testid
	 * @param testname
	 * @param pid
	 * @param testfee
	 * @return It return 1 if labtest successfully added otherwise it returns 0
	 * @throws SQLException
	 */
	public int addLabtest(String testid,String testname,String pid, String testfee) throws SQLException {
		
	
		  return this.jdbcTemplate.update("insert into labtest values ('"+testid+"','"+testname+"','"+pid+"','"+testfee+"')");
		  
		
		  }
		

	/**
	 * This method delete the labtest
	 * @param testid
	 * @return It return 1 if labtest successfully added otherwise it returns 0
	 * @throws SQLException
	 */
	public int deleteLabtest(String testid) throws SQLException{

	
		
		 return this.jdbcTemplate.update("delete from labtest where testid='"+testid+"' ");
				  
				
				  
	}
	
	/**
	 * This method update the labtest
	 * @param testid
	 * @param testname
	 * @param pid
	 * @param testfee
	 * @return It return 1 if drug successfully updated otherwise it returns 0
	 * @throws SQLException
	 */
	public int updateLabtest(String testid,String testname, String pid,String testfee) throws SQLException {
		
	
	return this.jdbcTemplate.update("update labtest set testname='"+testname+"',pid='"+pid+"',testfee='"+testfee+"' where testid='"+testid+"'");
			  
			
	}
	
	/**
	 * This method shows the list of labtest 
	 * @return It returns the list of labtest
	 * @throws SQLException
	 */
	public List<Map<String, Object>> listLabtest() throws SQLException {
		List<Map<String, Object>> list = new ArrayList<>();
		list = jdbcTemplate.queryForList("select * from labtest");
		return list;

}
	
	
	
}
