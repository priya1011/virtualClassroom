package com.example;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class TestDesc extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			
		System.out.println("forwarding to TestDesc.jsp");
		
		RequestDispatcher dispatcher = 
		        request.getRequestDispatcher("TestDesc.jsp");
		    dispatcher.forward( request, response ); 
	
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		HttpSession session =request.getSession();
		
		System.out.println("after submitting test desc");
		
		Faculty f=new Faculty(session.getAttribute("userid"));
		
		TestO t=new TestO(f.id,request.getParameter("testDesc"));
		
		
		int testid=TestO.AddTest(t);
		
		session.setAttribute("testId", testid);
		
		RequestDispatcher dispatcher = 
		        request.getRequestDispatcher("Test.jsp");
		    dispatcher.forward( request, response ); 
		
	}

}
