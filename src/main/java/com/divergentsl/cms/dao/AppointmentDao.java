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
import com.divergentsl.cms.dto.AppointmentDto;
/**
 * 
 * Class for AppointmentDao
 * 
 * @author Pooja Patidar
 *
 */

@Repository
public class AppointmentDao {
	
	/*
	 * @Autowired IDatabaseManager databaseManager;
	 */
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	private static Logger myLogger = LoggerFactory.getLogger(AppointmentDao.class);
	
	/**
	 * This method insert the appointment
	 * @param appid
	 * @param pid
	 * @param pname
	 * @param appdate
	 * @return It return 1 if appointment successfully added otherwise it returns 0 
	 * @throws SQLException
	 */
	public int addAppointment(String appid,String pid,String pname, String appdate) throws SQLException {
			
		  return this.jdbcTemplate.update("insert into appointment values ('"+appid+"','"+pid+"','"+pname+"','"+appdate+"')");
		  
		  
		  }
		
		
	

	/**
	 * This method delete the appointment of given id
	 * @param appid
	 * @return It return 1 if appointment successfully deleted otherwise it returns 0
	 * @throws SQLException
	 */
	public int deleteAppointment(String appid) throws SQLException{

		return this.jdbcTemplate.update("delete from appointment where appid='"+appid+"' ");
			
				  
		
		
	}
	
	/**
	 * This method update the appointment of given id
	 * @param appid
	 * @param pid
	 * @param pname
	 * @param appdate
	 * @return It return 1 if appointment successfully updated otherwise it returns 0
	 * @throws SQLException
	 */
	public int updateAppointment(String appid,String pid, String pname,String appdate) throws SQLException {

		
		return this.jdbcTemplate.update("update appointment set pid='"+pid+"',pname='"+pname+"',appdate='"+appdate+"' where appid='"+appid+"'");
				  
		
	}
	
	/**
	 * This method shows the list of appointment 
	 * @return It returns the list of appointment
	 * @throws SQLException
	 */
	public List<Map<String, Object>> listAppointment() throws SQLException {
		List<Map<String, Object>> list = new ArrayList<>();
		list = jdbcTemplate.queryForList("select * from appointment");
		return list;

}
	
	
	
}
