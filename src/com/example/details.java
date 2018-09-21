package com.example;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.sql.*;


public class details extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		RequestDispatcher dispatcher = 
		        request.getRequestDispatcher("details.jsp");
		    dispatcher.forward( request, response ); 
		
		
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session =request.getSession();
		
		int i=Faculty.details(session.getAttribute("userid"),request.getParameter("email"),request.getParameter("contact"));
		
		if(i>0)
		{
			RequestDispatcher dispatcher = 
		        request.getRequestDispatcher("details.jsp");
		    dispatcher.forward( request, response ); 
		}
		else
		{
			RequestDispatcher dispatcher = 
			        request.getRequestDispatcher("IncorrectDetails.jsp");
			    dispatcher.forward( request, response ); 
		}
	}




}
