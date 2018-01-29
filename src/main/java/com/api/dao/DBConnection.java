package com.api.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {

	public static Connection getConnection(String dbPath) {
		
		 Connection connection = null;
		 try {
			 Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
	         String dbURL = "jdbc:ucanaccess://"+ dbPath;
	         
	         connection = DriverManager.getConnection(dbURL); 
	         System.out.println("Connection established.....");
	 
	        }
	        catch(ClassNotFoundException cnfex) {
	            System.out.println("Problem in loading MS Access JDBC driver");
	            cnfex.printStackTrace();
	        }
	        catch(SQLException sqlex){
	            sqlex.printStackTrace();
	        }
		return connection;
	}
	
}
