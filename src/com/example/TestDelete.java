package com.example;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class TestUpdate
 */
@WebServlet("/TestUpdate")
public class TestDelete extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session =request.getSession();
		String desc=request.getParameter("testDesc");
		
		TestO t=new TestO((String)session.getAttribute("userid"),desc);
		
		int i=TestO.deleteTest(t);
		
		if(i>0)
		{
			RequestDispatcher dispatcher = 
			        request.getRequestDispatcher("TestDeleted.jsp");
			    dispatcher.forward( request, response ); 
		}
	}

}
