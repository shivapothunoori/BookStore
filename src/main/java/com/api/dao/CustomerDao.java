package com.api.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Random;

public class CustomerDao {

	public static int insertUserDetails(CustomerBean customer, String dbPath) {
		int reply = 0;
		try {
			Connection con = DBConnection.getConnection(dbPath);
			System.out.println("----connection----");
			 String sql = "Insert into CustomerT(CustID,FirstName,LastName, Address1, Address2, City, Country, Telephone, Email, UserName, Password1) values (?,?,?,?,?,?,?,?,?,?,?)";
			 System.out.println("sql::: " + sql);
			 PreparedStatement pst = con.prepareStatement(sql);

			 pst.setLong(1, getCustID());
			 pst.setString(2, customer.FirstName);
			 pst.setString(3, customer.LastName);
			 pst.setString(4, customer.Address1);
			 pst.setString(5, customer.Address2);
			 pst.setString(6, customer.city);
			 pst.setString(7, customer.Country);
			 pst.setString(8, customer.Telephone);
			 pst.setString(9, customer.Email);
			 pst.setString(10, customer.UserName);
			 pst.setString(11, customer.Password1);
			 int i = pst.executeUpdate();
			 System.out.println("=====I::: " + i);
			 if(i ==1 ){
				 reply = 1;
				 System.out.println("inserted success...");
			 }
			 con.close();
		}catch (SQLException e) {
			e.printStackTrace();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return reply;
	}
	
	public static int getUserDetails(CustomerBean customer, String dbPath) {
		int reply = 0;
		Connection con = null;
		try {
			con = DBConnection.getConnection(dbPath);
			 Statement st = con.createStatement();
			 String qry = "SELECT * FROM CustomerT where UserName='" + customer.UserName + "' and Password1='" + customer.Password1 + "'";
			 System.out.println("===> " + qry);
	         ResultSet rs = st.executeQuery(qry);
	        // System.out.println("RS: " + rs.next());
	            if(rs.next()){
	            	System.out.println("valid user......");
	            	return 1;
	            }
	            
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		System.out.println("User exists::::or:: " + reply);
		return reply;
	}
	private static int getCustID(){
		int id = 0;
		try{
			Random rand = new Random();
			id = rand.nextInt(900000) + 10000;
			String dbPath = "";
		    Connection con = DBConnection.getConnection(dbPath);
			 Statement st = con.createStatement();
			 String qry = "SELECT * FROM CustomerT where CustID=" + id;
	         ResultSet rs = st.executeQuery(qry);
	         System.out.println("CUSTID:: " + id);
	         if(rs.next()){
	        	 return id+1;
	         }
	         con.close();
		}catch (Exception e) {
			e.printStackTrace();
		}
		 		return id;
	} 
}
