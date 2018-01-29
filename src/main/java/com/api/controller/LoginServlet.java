package com.api.controller;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.api.dao.CustomerBean;
import com.api.dao.CustomerDao;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String dbPath = request.getServletContext().getRealPath("/") + "WEB-INF/db/BookStore.accdb";
		System.out.println("DB PATH: " + dbPath);
		CustomerBean customer = new CustomerBean();
		customer.UserName = request.getParameter("username");
		customer.Password1 = request.getParameter("password");
		int i = CustomerDao.getUserDetails(customer, dbPath);
		System.out.println("reply: " + i);
		ServletContext sc = getServletContext();
		
		if(i == 1){
//			response.sendRedirect("RegistrationSuccess.html");
			sc.getRequestDispatcher("/index.html").forward(request, response);	
		}else{
			sc.getRequestDispatcher("/myaccount.html").forward(request, response);
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
