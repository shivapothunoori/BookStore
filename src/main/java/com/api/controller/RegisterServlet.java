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
 * Servlet implementation class RegisterServlet
 */
@WebServlet("/register")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		CustomerBean customer = new CustomerBean();
		customer.FirstName = request.getParameter("fname");
		customer.LastName = request.getParameter("lname");
		customer.Address1 = request.getParameter("address1");
		customer.Address2 = request.getParameter("address2");
		customer.city = request.getParameter("city");
		customer.Country = request.getParameter("country");
		customer.Telephone = request.getParameter("phone");
		customer.Email = request.getParameter("email");
		customer.UserName = request.getParameter("username");
		customer.Password1 = request.getParameter("password");
		System.out.println("req.user:: " + request.getParameter("username"));
		System.out.println("customer.Password1: " + customer.Password1 );
		
		String dbPath = request.getServletContext().getRealPath("/") + "WEB-INF/db/BookStore.accdb";
		System.out.println("DB PATH: " + dbPath);
		int reply = CustomerDao.insertUserDetails(customer, dbPath);
		System.out.println("reply: " + reply);
		ServletContext sc = getServletContext();
		
		if(reply == 1){
//			response.sendRedirect("RegistrationSuccess.html");
			sc.getRequestDispatcher("/RegistrationSuccess.html").forward(request, response);	
		}else{
			sc.getRequestDispatcher("/registration.html").forward(request, response);
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
