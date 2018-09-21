package com.example;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.sql.*;

public class login extends HttpServlet {
	
	//private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.setContentType("text/html");
		System.out.println("hello from do get");

		
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.setContentType("text/html");
		
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		PrintWriter writer=response.getWriter();
		
		HttpSession session =request.getSession();
		
		
		System.out.println("hello there");
		
		Faculty f1=new Faculty();
		f1.id=request.getParameter("userid");   
	    f1.password = request.getParameter("pass");
	    String profession= request.getParameter("prof");
	    session.setAttribute("profession",profession);
	    session.setAttribute("userid", f1.id);
	    
	    if(profession.equals("Faculty"))
        {	
        	System.out.println("send redirect");
        	//writer.println("faculty");
        	session.setAttribute("profession",profession);
        	int i=LoginClass.check(f1);
        	if(i>0)
        		response.sendRedirect("/Faculty/facultyLogin");
        	
        	
        }	
	    
		/*
		
		//response.setContentType("text/html");
		
		String userid=null;
		
		
		
		userid = request.getParameter("userid");    
		f1.id=request.getParameter("userid");   
	    String pwd = request.getParameter("pass");
	    String p= request.getParameter("prof");
	    System.out.println(p + " here");
	    
	    System.out.println("userid= " +  userid);
	    try{
	    	
	    Class.forName("com.mysql.jdbc.Driver");
	    Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/test",
	            "root", "arushi");
	    Statement st = con.createStatement();
	    ResultSet rs;
	   // HttpSession session =request.getSession();
	    
	    if(p.equals("faculty") || p.equals("Faculty"))
	    {
	    	rs = st.executeQuery("select * from faculty where id='" + userid + "'and pass='" + pwd +"'");
	    }
	    
	    else
	    {
	    	rs = st.executeQuery("select * from members where id='" + userid + "' and pass='" + pwd + "and profession=" + "'" + p + "'");
	    }
	    
	   // rs = st.executeQuery("select * from members where id='" + userid + "' and pass='" + pwd + "and profession=" + "'" + p + "'");
	    if (rs.next()) {
	        session.setAttribute("userid", userid);
	        
	        session.setAttribute("profession", p);
	        
	        
	        System.out.println("welcome " + userid);
	        //out.println("<a href='logout.jsp'>Log out</a>");
	        if(p.equals("Faculty"))
	        {	
	        	System.out.println("send redirect");
	        	//writer.println("faculty");
	        	session.setAttribute("profession",p);
	        	response.sendRedirect("/Faculty/facultyLogin");
	        	//response.sendRedirect("/Faculty/successPath");
	        	
	        }	
	    } else {
	        writer.println("Invalid id or password <a href='index.jsp'>try again</a>");
	    }}
	    catch(Exception e)
	    {
	    	System.out.println(e.getMessage());
	    }*/
	}
		
}


