
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
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

import com.divergentsl.cms.dao.AppointmentDao;
import com.divergentsl.cms.databaseconnection.DatabaseManager;
import com.divergentsl.cms.dto.AppointmentDto;
import com.divergentsl.cms.dto.LabtestDto;

/**
 * Class for CRUD Appointment
 * @author Pooja Patidar
 *
 */
@Component
public class CRUDAppointment {
	private static Logger myLogger = LoggerFactory.getLogger(CRUDAppointment.class); 
	
	@Autowired
	private AppointmentDao appointmentdao;
	
	

	public void crudAppointment() {

		exit: while (true) {
			
			
			System.out.println("------CRUD Apoointment-----");
			System.out.println("1.Add");
			System.out.println("2.Delete");
			System.out.println("3.Update");
			System.out.println("4.List of Appointment");
			System.out.println("5.Exit");
			
			Scanner sc = new Scanner(System.in);
			System.out.println("Enter your choice=");
			int input = sc.nextInt();

			switch (input) {
			case 1:
				addAppointment();
				break;
			case 2:
				deleteAppointment();
				break;
			case 3:
				updateAppointment();
				break;
			case 4:
				listAppointment();
				break;
			case 5:
				break exit;
			default:
				myLogger.debug( "Invalid Input!");
				break;
			}

		}
	}

	/**
	 * method for inserting the appointment
	 */
	public void addAppointment() {
		
		AppointmentDto appointmentDto= new AppointmentDto();
		
		System.out.println("----Add Appointment-----");
		Scanner sc = new Scanner(System.in);

		System.out.println("Enter Appointment id=");
		String appid = sc.nextLine();
		appointmentDto.setAppid(appid);

		System.out.println("Enter patient id=");
		String pid = sc.nextLine();
		appointmentDto.setPid(pid);

		System.out.println("Enter patient name=");
		String pname = sc.nextLine();
		appointmentDto.setPname(pname);

		System.out.println("Enter Appointment date=");
		String appdate = sc.nextLine();
		appointmentDto.setAppdate(appdate);

		//AppointmentDao appointmentdao = new AppointmentDao(new DatabaseManager());
		if(validateAppointmentDto(appointmentDto)) {
			return;
		}
		try {
			appointmentdao.addAppointment(appid, pid, pname, appdate);
			
			System.out.println("Added Successfully");
		} catch (SQLException e) {
			myLogger.debug(e.getMessage());
		}

	}
	 public boolean validateAppointmentDto(AppointmentDto appointmentDto) {
			
			ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
			Validator validator =factory.getValidator();
			
			Set<ConstraintViolation<AppointmentDto>> violations = validator.validate(appointmentDto);
			
			for(ConstraintViolation<AppointmentDto> violation :violations) {
				myLogger.error(violation.getMessage());
			}
			
			return violations.size() > 0;
			
			
		}

	/**
	 * method for deleting the the appointment
	 */
	public void deleteAppointment() {

		Scanner sc = new Scanner(System.in);
		
		System.out.println("-----Delete appointment------");
		System.out.println("Enter the app id=");
		String appid = sc.nextLine();

		//AppointmentDao appointmentdao = new AppointmentDao(new DatabaseManager());

		try {
			appointmentdao.deleteAppointment(appid);
			System.out.println("Deleted Successfully");
		} catch (SQLException e) {
			myLogger.debug(e.getMessage());
		}
	}

	/**
	 * method for updating the appointment
	 */
	public void updateAppointment() {

		Scanner sc = new Scanner(System.in);
	
		System.out.println("----Update Appointment----");
		System.out.println("Enter appointment id=");
		String appid = sc.nextLine();
		System.out.println("Enter new patient id=");
		String pid = sc.nextLine();
		System.out.println("Enter new patient name=");
		String pname = sc.nextLine();
		System.out.println("Enter new app date=");
		String appdate = sc.nextLine();

		//AppointmentDao appointmentdao = new AppointmentDao(new DatabaseManager());

		try {
			appointmentdao.updateAppointment(appid, pid, pname, appdate);
			
			System.out.println("Updated Successfully");
		} catch (SQLException e) {
			myLogger.debug(e.getMessage());
			
		}

	}

	/**
	 * method for showing the list of the appointment
	 */
	public void listAppointment() {
	
			System.out.println(
			"--------------------------------------Appointment List---------------------------------------------");

			try {

			List<Map<String, Object>> list = appointmentdao.listAppointment();
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
