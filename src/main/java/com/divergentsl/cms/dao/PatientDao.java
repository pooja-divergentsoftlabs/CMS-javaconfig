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
import com.divergentsl.cms.dto.PatientDto;

/**
 * Class for Patient Dao
 * 
 * @author Pooja Patidar
 *
 */
@Repository
public class PatientDao {
	
	/*
	 * @Autowired IDatabaseManager databaseManager;
	 */

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	private static Logger myLogger = LoggerFactory.getLogger(PatientDao.class);

	/**
	 *  This method insert the patient
	 * @param pid
	 * @param pname
	 * @param paddress
	 * @param pcontactnumber
	 * @param page
	 * @param pweight
	 * @return It return 1 if patient successfully added otherwise it returns 0 
	 * @throws SQLException
	 */
	public int addPatient(String pid, String pname, String paddress, String pcontactnumber, String page, String pweight)
			throws SQLException {
     

      return this.jdbcTemplate.update ("insert into patient values ('" + pid + "','" + pname + "','" + paddress + "','"
				+ pcontactnumber + "','" + page + "','" + pweight + "')");
	 
	  

	}

	/**
	 * This method delete the doctor
	 * @param pid
	 * @return It return 1 if patient successfully added otherwise it returns 0
	 * @throws SQLException
	 */
	public int deletePatient(String pid) throws SQLException {

	
	
	 
			  return this.jdbcTemplate.update("delete from patient where pid='" + pid + "'");
			  
			 
	}

	/**
	 * This method update the patient of given id
	 * @param pid
	 * @param pname
	 * @param paddress
	 * @param pcontactnumber
	 * @param page
	 * @param pweight
	 * @return It return 1 if patient successfully updated otherwise it returns 0
	 * @throws SQLException
	 */
	public int updatePatient(String pid, String pname, String paddress, String pcontactnumber, String page,
			String pweight) throws SQLException {
	
	 
	return this.jdbcTemplate.update("update patient set pname='" + pname + "',paddress='" + paddress + "',pcontactnumber='"
						+ pcontactnumber + "',page='" + page + "',pweight='" + pweight + "' where pid='" + pid + "' ");
			  
			  	
	
	}

	/**
	 * This method shows the list of patient 
	 * @return It returns the list of patient 
	 * @throws SQLException
	 */
	public List<Map<String, Object>> listPatient() throws SQLException {
		List<Map<String, Object>> list = new ArrayList<>();
		list = jdbcTemplate.queryForList("select * from patient");
		return list;
	}

}
