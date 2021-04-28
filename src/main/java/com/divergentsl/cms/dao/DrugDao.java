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
import com.divergentsl.cms.dto.DrugDto;

/**
 * Class for Drug Dao
 * @author Pooja Patidar
 *
 */
@Repository
public class DrugDao {
	
	/*
	 * @Autowired IDatabaseManager databaseManager;
	 */
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	private static Logger myLogger = LoggerFactory.getLogger(DrugDao.class);
	
	/**
	 * This method insert the drug
	 * @param drugid
	 * @param drugname
	 * @param drugdescription
	 * @param drugquantity
	 * @param drugprice
	 * @return It return 1 if drug successfully added otherwise it returns 0
	 * @throws SQLException
	 */
	public int addDrug(String drugid,String drugname,String drugdescription, String drugquantity,String drugprice) throws SQLException {
		
	
		
    return this.jdbcTemplate.update("insert into drug values ('"+drugid+"','"+drugname +"','"+drugdescription+"','"+drugquantity+"','"+drugprice+"')");
		
	}
	

	/**
	 * This method delete the drug
	 * @param drugid
	 * @return It return 1 if drug successfully added otherwise it returns 0
	 * @throws SQLException
	 */
	public int deleteDrug(String drugid) throws SQLException{

	
		 
				return  this.jdbcTemplate.update("delete from drug where drugid='" + drugid + "'");
				  
				 
		
	}
	
	/**
	 * This method update the drug of given id
	 * @param drugid
	 * @param drugname
	 * @param drugdescription
	 * @param drugquantity
	 * @param drugprice
	 * @return It return 1 if doctor successfully updated otherwise it returns 0
	 * @throws SQLException
	 */
	public int updateDrug(String drugid,String drugname,String drugdescription, String drugquantity,String drugprice) throws SQLException {
		
	
	
		 
				 return this.jdbcTemplate.update("update drug set drugname='"+drugname+"', drugdescription='"+drugdescription+"',drugquantity='"+drugquantity+"',drugprice='"+drugprice+"' where drugid='"+drugid+"'");
				  
		
		
	}
	
	/**
	 * This method shows the list of drug 
	 * @return It returns the list of drug
	 * @throws SQLException
	 */
	public List<Map<String, Object>> listDrug() throws SQLException {
		List<Map<String, Object>> list = new ArrayList<>();
		list = jdbcTemplate.queryForList("select * from drug");
		return list;

}
}
		
	
	
	

