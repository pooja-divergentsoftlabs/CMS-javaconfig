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
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.divergentsl.cms.databaseconnection.IDatabaseManager;
import com.divergentsl.cms.dto.DoctorDto;


/**
 * Class for DoctorDao
 * 
 * @author Pooja Patidar
 *
 */

@Repository
public class DoctorDao {

	
	// @Autowired IDatabaseManager databaseManager;
	 
	
	  @Autowired JdbcTemplate jdbcTemplate;
	 
	
	private static Logger myLogger = LoggerFactory.getLogger(DoctorDao.class);

	/**
	 * This method insert the doctor
	 * 
	 * @param did
	 * @param dname
	 * @param dspeciality
	 * @param dcontactnumber
	 * @param dfees
	 * @return It return 1 if doctor successfully added otherwise it returns 0
	 * @throws SQLException
	 */
	public int addDoctor(String did, String dname, String dspeciality, String dcontactnumber, String dfees)
			throws SQLException {

	
		
		return this.jdbcTemplate.update("insert into doctor values ('" + did + "','" +
		  dname + "','" + dspeciality + "','" + dcontactnumber + "','" + dfees + "')");
		  
		  }
		 

	/**
	 * This method delete the doctor
	 * 
	 * @param did
	 * @return It return 1 if doctor successfully added otherwise it returns 0
	 * @throws SQLException
	 */
	public int deleteDoctor(String did) throws SQLException {

				  
		return this.jdbcTemplate.update("delete from doctor where did='" + did + "'");
				  
				 
				  }
	
	

	/**
	 * This method update the doctor of given id
	 * 
	 * @param did
	 * @param dname
	 * @param dspeciality
	 * @param dcontactnumber
	 * @param dfees
	 * @return It return 1 if doctor successfully updated otherwise it returns 0
	 * @throws SQLException
	 */
	public int updateDoctor(String did, String dname, String dspeciality, String dcontactnumber, String dfees)
			throws SQLException {

		
		 return this.jdbcTemplate.update("update doctor set dname='" + dname +
				  "', dspeciality='" + dspeciality + "',dcontactnumber='" + dcontactnumber +
				 "',dfees='" + dfees + "' where did='" + did + "'  ");
				  
				 
				  }
	
		
	/**
	 * This method shows the list of doctor
	 * 
	 * @return It returns the list of doctor
	 * @throws SQLException
	 */
			public List<Map<String, Object>> listDoctor() throws SQLException {
			List<Map<String, Object>> list = new ArrayList<>();
			list = jdbcTemplate.queryForList("select * from doctor");
			return list;

}
	}