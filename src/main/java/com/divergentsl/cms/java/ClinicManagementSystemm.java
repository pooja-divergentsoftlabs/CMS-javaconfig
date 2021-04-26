package com.divergentsl.cms.java;


import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.validation.annotation.Validated;

import com.divergentsl.cms.dto.DoctorDto;


/**
 * Main class for Clinic Management System
 * 
 * @author Pooja Patidar
 *
 */
public class ClinicManagementSystemm {
	
	private static Logger myLogger = LoggerFactory.getLogger(ClinicManagementSystemm.class);

	
	public static void main(String args[]) {
		
		
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.getEnvironment().setActiveProfiles("dev");
		context.register(JavaConfig.class);
		context.refresh();	
		LoginPage loginPage = context.getBean(LoginPage.class);
	
		loginPage.loginPage();
		
				
	}
	
	
	
	}


