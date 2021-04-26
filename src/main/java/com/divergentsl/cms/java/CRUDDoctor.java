package com.divergentsl.cms.java;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import com.divergentsl.cms.dao.DoctorDao;
import com.divergentsl.cms.databaseconnection.DatabaseManager;
import com.divergentsl.cms.dto.DoctorDto;

/**
 * Class for CRUD Doctor
 * 
 * @author Pooja Patidar
 *
 */
@Component
public class CRUDDoctor {
	private static Logger myLogger = LoggerFactory.getLogger(CRUDDoctor.class);

	@Autowired
	private DoctorDao doctorDao;
	
	
	
	public void crudDoctor() {
		
		exit: while (true) {
			
			System.out.println("-----CRUDDoctor----");
			System.out.println("1.Add");
			System.out.println("2.Delete");
			System.out.println("3.Update");
			System.out.println("4.List of doctor");
			System.out.println("5.Exit");
			
			Scanner sc = new Scanner(System.in);
			System.out.println("Enter your choice=");
			int input = sc.nextInt();
			
			

			switch (input) {
			case 1:
				addDoctor();
				break;
			case 2:
				deleteDoctor();
				break;
			case 3:
				updateDoctor();
				break;
			case 4:
				listDoctor();
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
	 * method for inserting the doctor
	 */
	public void addDoctor() {
		
		DoctorDto doctorDto= new DoctorDto();
		
		
		System.out.println("----Add Doctor----");
		Scanner sc = new Scanner(System.in);

		System.out.println("Enter id=");
		String did = sc.nextLine();
		doctorDto.setDid(did);

		System.out.println("Enter name=");
		String dname = sc.nextLine();
		doctorDto.setDname(dname);

		System.out.println("Enter speciality=");
		String dspeciality = sc.nextLine();
		doctorDto.setDspeciality(dspeciality);

		System.out.println("Enter contact number=");
		String dcontactnumber = sc.nextLine();
		doctorDto.setDcontactnumber(dcontactnumber);

		System.out.println("Enter fees=");
		String dfees = sc.nextLine();
		doctorDto.setDfees(dfees);

//		DoctorDao doctordao = new DoctorDao(new DatabaseManager());
		
		if(validateDoctorDto(doctorDto)) {
			return;
		}
		try {
			doctorDao.addDoctor(did, dname, dspeciality, dcontactnumber, dfees);
			
			System.out.println("Added Successfully");
		} catch (SQLException e) {
			myLogger.debug(e.getMessage());
		}

	}
	
	  public boolean validateDoctorDto(DoctorDto doctorDto) {
			
			ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
			Validator validator =factory.getValidator();
			
			Set<ConstraintViolation<DoctorDto>> violations = validator.validate(doctorDto);
			
			for(ConstraintViolation<DoctorDto> violation :violations) {
				myLogger.error(violation.getMessage());
			}
			
			return violations.size() > 0;
			
			
		}
		

	/**
	 * method for deleting the doctor
	 */
	public void deleteDoctor() {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("----Delete Doctor----");
		System.out.println("Enter the id=");
		String did = sc.nextLine();

//		DoctorDao doctordao = new DoctorDao(new DatabaseManager());
		try {
			doctorDao.deleteDoctor(did);
			
			System.out.println("Deleted Successfully");
		} catch (SQLException e) {
			myLogger.debug(e.getMessage());
		}

	}
	
	  
	

	/**
	 * method for updating the doctor
	 */
	public void updateDoctor() {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("----Update Doctor----");
		System.out.println("Enter the id =");
		String did = sc.nextLine();
		System.out.println("Enter new name=");
		String dname = sc.nextLine();
		System.out.println("Enter new doctor speciality=");
		String dspeciality = sc.nextLine();
		System.out.println("Enter new doctor contactnumber=");
		String dcontactnumber = sc.nextLine();
		System.out.println("Enter new doctor fees=");
		String dfees = sc.nextLine();

//		DoctorDao doctordao = new DoctorDao(new DatabaseManager());
		try {
			doctorDao.updateDoctor(did, dname, dspeciality, dcontactnumber, dfees);
			
			System.out.println("Updated Successfully");
		} catch (SQLException e) {
			myLogger.debug(e.getMessage());
		}

	}

	/**
	 * method for showing the list of doctor
	 */
	public void listDoctor() {
		System.out.println("----List of Doctor----");
		

		try {
//			DoctorDao doctordao = new DoctorDao(new DatabaseManager());
			List<DoctorDto> dtos = doctorDao.listDoctor();

			for (DoctorDto doctorDto : dtos) {
				System.out.printf(" %10s %30s %15s  %20s %20s", doctorDto.getDid(), doctorDto.getDname(),
						doctorDto.getDspeciality(), doctorDto.getDcontactnumber(), doctorDto.getDfees());
				System.out.println("\n");
			}

		} catch (SQLException e) {
			myLogger.debug(e.getMessage());
		}
	}
}
