package com.divergentsl.cms.java;


import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


/**
 * Main class for Clinic Management System
 * 
 * @author Pooja Patidar
 *
 */
public class ClinicManagementSystemm {

	
	public static void main(String args[]) {
		
		
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.getEnvironment().setActiveProfiles("dev");
		context.register(JavaConfig.class);
		context.refresh();	
		LoginPage loginPage = context.getBean(LoginPage.class);
	
		loginPage.loginPage();
		
	}
	}


