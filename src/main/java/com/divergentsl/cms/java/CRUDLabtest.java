package com.divergentsl.cms.java;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.Map.Entry;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import com.divergentsl.cms.dao.LabtestDao;
import com.divergentsl.cms.databaseconnection.DatabaseManager;
import com.divergentsl.cms.dto.DrugDto;
import com.divergentsl.cms.dto.LabtestDto;

/**
 * Class for CRUDLabtest
 * 
 * @author Pooja Patidar
 *
 */
@Component
public class CRUDLabtest {
	private static Logger myLogger= LoggerFactory.getLogger(CRUDLabtest.class);
	
	@Autowired
	private LabtestDao labtestdao;
	
	public void crudLabtest() {

		exit: while (true) {
	
			System.out.println("------CRUD Labtest-----");
			System.out.println("1.Add");
			System.out.println("2.Delete");
			System.out.println("3.Update");
			System.out.println("4.List of labtest");
			System.out.println("5.Exit");
			
			Scanner sc = new Scanner(System.in);
			System.out.println("Enter your choice=");
			int input = sc.nextInt();

			switch (input) {
			case 1:
				addLabtest();
				break;
			case 2:
				deleteLabtest();
				break;
			case 3:
				updateLabtest();
				break;
			case 4:
				listLabtest();
				break;
			case 5:
				break exit;
				default:
					myLogger.debug("Invalid Input");
					break;

			}

		}
	}

	/**
	 * method to add labtest
	 */
	public void addLabtest() {
		
		LabtestDto labtestDto = new LabtestDto();
		
		System.out.println("----Add Labtest-----");
		Scanner sc = new Scanner(System.in);

		System.out.println("Enter test id=");
		String testid = sc.nextLine();
		labtestDto.setTestid(testid);

		System.out.println("Enter test name=");
		String testname = sc.nextLine();
		labtestDto.setTestname(testname);

		System.out.println("Enter patient id=");
		String pid = sc.nextLine();
		labtestDto.setPid(pid);

		System.out.println("Enter test fee=");
		String testfee = sc.nextLine();
		labtestDto.setTestfee(testfee);

		//LabtestDao labtestdao = new LabtestDao(new DatabaseManager());
		if(validateLabtestDto(labtestDto)) {
			return;
		}
		try {
			labtestdao.addLabtest(testid, testname, pid, testfee);
			
			System.out.println("Added Successfully");
		} catch (SQLException e) {
			myLogger.debug(e.getMessage());
		}

	}
	
	  public boolean validateLabtestDto(LabtestDto labtestDto) {
			
			ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
			Validator validator =factory.getValidator();
			
			Set<ConstraintViolation<LabtestDto>> violations = validator.validate(labtestDto);
			
			for(ConstraintViolation<LabtestDto> violation :violations) {
				myLogger.error(violation.getMessage());
			}
			
			return violations.size() > 0;
			
			
		}

	/**
	 * method to delete the labtest
	 */
	public void deleteLabtest() {

		Scanner sc = new Scanner(System.in);
		
		System.out.println("-----Delete Labtest------");
		System.out.println("Enter the test id=");
		String testid = sc.nextLine();

		//LabtestDao labtestdao = new LabtestDao(new DatabaseManager());

		try {
			labtestdao.deleteLabtest(testid);
			
			System.out.println("Deleted Successfully");
		} catch (SQLException e) {
			myLogger.debug(e.getMessage());
		}
	}

	/**
	 * method to update the labtest
	 */
	public void updateLabtest() {

		Scanner sc = new Scanner(System.in);
		
		System.out.println("----Update Labtest----");
		System.out.println("Enter test id=");
		String testid = sc.nextLine();
		System.out.println("Enter new test name=");
		String testname = sc.nextLine();
		System.out.println("Enter new patient id=");
		String pid = sc.nextLine();
		System.out.println("Enter new test fee=");
		String testfee = sc.nextLine();

		//LabtestDao labtestdao = new LabtestDao(new DatabaseManager());

		try {
			labtestdao.updateLabtest(testid, testname, pid, testfee);
			
			System.out.println("Updated Successfully");
		} catch (SQLException e) {
			myLogger.debug(e.getMessage());
		}

	}

	/**
	 * method to list the labtest
	 */
	public void listLabtest() {
		System.out.println(
		"--------------------------------------Labtest List---------------------------------------------");

		try {

		List<Map<String, Object>> list = labtestdao.listLabtest();
		if (list != null) {

		// logger.info("id\t name \t speciality\t fee\n");

		for (Map<String, Object> map : list) {
		for (Entry<String, Object> get : map.entrySet()) {

		System.out.printf("%20s", get.getValue());

		}
		myLogger.info("\n");
		}
		}
		} catch (SQLException e) {
		myLogger.debug("----------Can't read---------" + e.getMessage());
		}

		}

}
