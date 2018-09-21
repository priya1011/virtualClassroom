package com.example;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class Test extends HttpServlet {


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	

		
		System.out.println("forwarding to Test.jsp");
		
		RequestDispatcher dispatcher = 
			        request.getRequestDispatcher("Test.jsp");
			    dispatcher.forward( request, response ); 
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session =request.getSession();
		Object id=session.getAttribute("userid");
		Object testid=session.getAttribute("testId");
		Question q1=new Question();
		
		q1.ques=request.getParameter("question");
		q1.option1=request.getParameter("option1");
		q1.option2=request.getParameter("option2");
		q1.option3=request.getParameter("option3");
		q1.option4=request.getParameter("option4");
		q1.ans=request.getParameter("answer");
		
		int i=Faculty.InsertQuestion(id,testid,q1);
		
		
		if(i>0)
		{
		RequestDispatcher dispatcher = 
		        request.getRequestDispatcher("TestUploaded.jsp");
		    dispatcher.forward( request, response ); 
		
		}
		else
		{
			RequestDispatcher dispatcher = 
			        request.getRequestDispatcher("QuestionFailed.jsp");
			    dispatcher.forward( request, response ); 
		}
	}
	
		
}

