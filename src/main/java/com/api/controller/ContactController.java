package com.api.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



/**
 * Servlet implementation class ContactController
 */
public class ContactController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ContactController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/*try {
			String dbPath = request.getServletContext().getRealPath("/") + "WEB-INF/db/BookStore.accdb";
			Connection con =  DBConnection.getConnection(dbPath);
			System.out.println("----connection----");
			 String sql = "Insert into Contact(CustomerName,Telephone, Address, Comment) values (?,?,?,?)";
			 System.out.println("sql::: " + sql);
			 PreparedStatement pst = con.prepareStatement(sql);

			 pst.setString(1, request.getParameter("CustomerName"));
			 pst.setString(2, request.getParameter("Telephone"));
			 pst.setString(3, request.getParameter("Address"));
			 pst.setString(4, request.getParameter("Comment"));
			
			 int i = pst.executeUpdate();
			 System.out.println("=====I::: " + i);
			 if(i ==1 ){
				 System.out.println("insert success...");
			 }
			 con.close();
		}catch (SQLException e) {
			e.printStackTrace();
		}
		catch (Exception e) {
			e.printStackTrace();
		}*/
	}

}
