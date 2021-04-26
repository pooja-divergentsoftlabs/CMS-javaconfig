package com.divergentsl.cms.java;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Class for Login Page
 * 
 * @author Pooja Patidar
 *
 */
@Component
public class LoginPage {
	private static Logger myLogger = LoggerFactory.getLogger(LoginPage.class);
	
	
	@Autowired
	AdminPanel adminPanel;
	@Autowired
	DoctorLogin doctorLogin;

	public void loginPage() {

		exit: while (true) {
		
			System.out.println("------Clinic Management System-------");
			System.out.println("------LOGIN PAGE-----");
			System.out.println("1.Admin");
			System.out.println("2.Doctor");
			System.out.println("3.Exit");
			

			Scanner sc = new Scanner(System.in);
			System.out.println("Enter your choice=");
			int input = sc.nextInt();

			switch (input) {

			case 1:
				if(adminLogin()) {
				adminPanel.adminPanel();
				}
				else {
					myLogger.debug("Wrong id/password");
					//System.out.println("Wrong id/password");
				}
				break;

			case 2:
				if(doctorLogin()) {
					doctorLogin.doctorPanel();
				}else {
					myLogger.debug("Wrong id/password");
					//System.out.println("Wrong id/password");
				}
				break;

			case 3:
				myLogger.debug("-----Exit-----");
				//System.out.println("----EXIT----");
				break exit;
				
				default:
					myLogger.debug("Invalid Input");
					break;

			}
		}
	}
	
	
	 public static boolean adminLogin(){
	        Scanner sc = new Scanner(System.in);

	        System.out.println("Enter username=");
	        String username = sc.nextLine();

	        System.out.println("Enter password=");
	        String password = sc.nextLine();

	        try{
	            Class.forName("com.mysql.cj.jdbc.Driver");
	            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/clinic_management_system","root","root");
	            Statement st = con.createStatement();
	            ResultSet rs = st.executeQuery("SELECT * FROM adminn where a_username = '"+username+"' && a_password = '"+password+"'");
	            if(rs.next()){
	           
	               System.out.println("Login Successful");
	                return true;
	            }
	            else{
	            	myLogger.debug("Wrong username/password");
	                
	                return false;
	            }

	        } catch (ClassNotFoundException | SQLException e) {
	        	myLogger.debug(e.getMessage());
	        }


	        return false;
	    }
	 
	 
	 public static boolean doctorLogin(){
	        Scanner sc = new Scanner(System.in);

	        System.out.println("Enter username=");
	        String username = sc.nextLine();

	        System.out.println("Enter password");
	        String password = sc.nextLine();

	        try {
	            Class.forName("com.mysql.cj.jdbc.Driver");
	            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/clinic_management_system","root","root");
	            Statement st = con.createStatement();
	            ResultSet rs = st.executeQuery("SELECT * FROM doctorlogin where d_username='"+username+"'&& d_password='"+password+"' ");
	            if(rs.next()){
	            	
	                System.out.println("Login successful");
	                return true;
	            }
	            else{
	            	myLogger.debug("Wrong username/password");
	               // System.out.println("Wrong username/password");
	                return false;
	            }
	        } catch (ClassNotFoundException e) {
	        	myLogger.debug(e.getMessage());
	        } catch (SQLException throwables) {
	            throwables.printStackTrace();
	        }
	        return false;
	    }

	 
	 
	 
	 
}
	
	
	 
