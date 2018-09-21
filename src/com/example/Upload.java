package com.example;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class Upload extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("in Upload");
		
		System.out.println("forwarding to Upload.jsp");
		
		RequestDispatcher dispatcher = 
			        request.getRequestDispatcher("Upload.jsp");
			    dispatcher.forward( request, response ); 
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		response.setContentType("text/html");
		
		HttpSession session =request.getSession();
		
		System.out.println(session.getAttribute("userid"));
		
		Link link=new Link();
		
		link.description=request.getParameter("description");
	    link.url=request.getParameter("url");
	    
		Object id= session.getAttribute("userid");
		int i= Faculty.uploadLink(id,link);
		
		if(i>0)
		{
			System.out.println("upload successful");
			response.sendRedirect("Uploaded.jsp");
		}
		 else
		{
			 response.sendRedirect("UploadFailed.jsp");
		    	
		}
		/*Object id= session.getAttribute("userid");
		//String id=request.getParameter("userid");
		System.out.println("id = " + id);
		
		try
		{
			
			 	Class.forName("com.mysql.jdbc.Driver");
			    Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/test",
			            "root", "arushi");
			    Statement st = con.createStatement();
			   
			    String des=request.getParameter("description");
			    String url=request.getParameter("url");
			    
			    int i = st.executeUpdate("insert into upload (id,description,link,uploadate) values('" + id + "','" + des + "','" + url + "', CURDATE())");
			
			    if(i>0)
			    {
			    	System.out.println("uploaded");
			    	
			    	//this.onSubmit();
			    	
			    	RequestDispatcher dispatcher = 
					        request.getRequestDispatcher("Uploaded.jsp");
					    dispatcher.forward( request, response ); 
			    	
			    }
			    else
			    {
			    	response.getWriter().append("Upload failed Try again");
			    	
			    }
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
		
		*/
		
	}

}
