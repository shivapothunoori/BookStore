package com.api.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import com.api.dao.DBConnection;

/**
 * Servlet implementation class CategoryController
 */
@WebServlet("/categories")
public class CategoryController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CategoryController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	@SuppressWarnings("unchecked")
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		JSONArray arr = new JSONArray();
		Connection con = null;
		try {
			String dbPath = request.getServletContext().getRealPath("/") + "WEB-INF/db/BookStore.accdb";
			con = DBConnection.getConnection(dbPath);
			 Statement st = con.createStatement();
			 String qry = "select SubCat from SubCategoryT";
	            ResultSet rs = st.executeQuery(qry);
	            
	            while(rs.next()){
	            	JSONObject json = new JSONObject();
	            	json.put("SubCat", rs.getString("SubCat"));
	            	arr.add(json);
	            }
	            response.setContentType("application/json");
	    		PrintWriter out = response.getWriter();
	    		out.print(arr);
	    		out.flush();
	            
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
