package com.api.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class BooksDao {

	@SuppressWarnings("unchecked")
	public static JSONArray getBooksList(String dbPath){
		
		JSONArray arr = new JSONArray();
		Connection con = null;
		try {
			con = DBConnection.getConnection(dbPath);
			 Statement st = con.createStatement();
			 String qry = "SELECT * FROM WarehouseT";
			 System.out.println("===> " + qry);
	         ResultSet rs = st.executeQuery(qry);
	        // System.out.println("RS: " + rs.next());
	         
	            while(rs.next()){
	            	JSONObject json = new JSONObject();
	            		json.put("BookID", rs.getString("BookID"));
	            		json.put("CatID", rs.getString("CatID"));
	            		json.put("SID", rs.getString("SID"));
	            		json.put("Sub_Category", rs.getString("Sub_Category"));
	            		json.put("BookName", rs.getString("BookName"));
	            		json.put("Author", rs.getString("Author"));
	            		json.put("Edition", rs.getString("Edition"));
	            		json.put("Quantity", rs.getString("Quantity"));
	            		json.put("Price", rs.getString("Price"));
	            		json.put("Picture", rs.getString("Picture"));
	            		arr.add(json);
	            }
	            rs.close();
	           
	            
	            
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return arr;
	}
}
