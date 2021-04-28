package com.divergentsl.cms.java;

import java.sql.SQLException;
import java.sql.Statement;
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
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

import com.divergentsl.cms.dao.DrugDao;
import com.divergentsl.cms.databaseconnection.DatabaseManager;
import com.divergentsl.cms.dto.DoctorDto;
import com.divergentsl.cms.dto.DrugDto;

/**
 * Class for CRUD Drug
 * @author Pooja Patidar
 *
 */
@Component
public class CRUDDrug {
	private static Logger myLogger = LoggerFactory.getLogger(CRUDDrug.class);
	
	@Autowired
	private DrugDao drugdao;
	
	
	public void crudDrug() {

		exit: while (true) {
			System.out.println("-----CRUDDrug----");
			System.out.println("1.Add");
			System.out.println("2.Delete");
			System.out.println("3.Update");
			System.out.println("4.List of drug");
			System.out.println("5.Exit");
			
			Scanner sc = new Scanner(System.in);
			System.out.println("Enter your choice=");
			int input = sc.nextInt();

			switch (input) {
			case 1:
				addDrug();
				break;
			case 2:
				deleteDrug();
				break;
			case 3:
				updateDrug();
				break;
			case 4:
				listDrug();
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
	 * method to insert the drug
	 */
	public void addDrug() {
		
		DrugDto drugDto = new DrugDto();
		
		System.out.println("----Add Drug-----");
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter drug id=");
		String drugid = sc.nextLine();
		drugDto.setDrugid(drugid);

		System.out.println("Enter drug name=");
		String drugname = sc.nextLine();
		drugDto.setDrugname(drugname);

		System.out.println("Enter drug description=");
		String drugdescription = sc.nextLine();
		drugDto.setDrugdescription(drugdescription);

		System.out.println("Enter quantity=");
		String drugquantity = sc.nextLine();
		drugDto.setDrugquantity(drugquantity);

		System.out.println("Enter drugprice=");
		String drugprice = sc.nextLine();
		drugDto.setDrugprice(drugprice);

		//DrugDao drugdao = new DrugDao(new DatabaseManager());
		
		if(validateDrugDto(drugDto)) {
			return;
		}
		try {
			drugdao.addDrug(drugid, drugname, drugdescription, drugquantity, drugprice);
			
			System.out.println("Added Successfully");
		} catch (SQLException e) {
			myLogger.debug(e.getMessage());
		}

	}
	
	  public boolean validateDrugDto(DrugDto drugDto) {
			
			ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
			Validator validator =factory.getValidator();
			
			Set<ConstraintViolation<DrugDto>> violations = validator.validate(drugDto);
			
			for(ConstraintViolation<DrugDto> violation :violations) {
				myLogger.error(violation.getMessage());
			}
			
			return violations.size() > 0;
			
			
		}

	/**
	 * method to delete the drug
	 */
	public void deleteDrug() {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("-----Delete Drug------");
		System.out.println("Enter the drug id=");
		String drugid = sc.nextLine();

		//DrugDao drugdao = new DrugDao(new DatabaseManager());

		try {
			drugdao.deleteDrug(drugid);
			
			System.out.println("Deleted Successfully");
		} catch (SQLException e) {
			myLogger.debug(e.getMessage());
		}
	}

	/**
	 * method to update the drug
	 */
	public void updateDrug() {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("----Update Drug----");
		System.out.println("Enter drug id=");
		String drugid = sc.nextLine();
		System.out.println("Enter new drug name=");
		String drugname = sc.nextLine();
		System.out.println("Enter new drug description=");
		String drugdescription = sc.nextLine();
		System.out.println("Enter new drug quantity=");
		String drugquantity = sc.nextLine();
		System.out.println("Enter new drug price=");
		String drugprice = sc.nextLine();

		//DrugDao drugdao = new DrugDao(new DatabaseManager());
		try {
			drugdao.updateDrug(drugid, drugname, drugdescription, drugquantity, drugprice);
			
			System.out.println("Updated Successfully");
		} catch (SQLException e) {
			// TODO: handle exception
			myLogger.debug(e.getMessage());
		}

	}

	/**
	 * method to show the list of drug
	 */
	public void listDrug() {
		System.out.println(
		"--------------------------------------Drug List---------------------------------------------");

		try {

		List<Map<String, Object>> list = drugdao.listDrug();
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
