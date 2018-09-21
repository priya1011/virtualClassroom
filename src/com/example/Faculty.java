package com.example;
import java.io.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import javax.servlet.http.HttpSession;



public class Faculty {

	String id;
	String first_name,last_name,email,password,date,dob,contact;
	String subject,qualifications,address;
	
	public Faculty()
	{
		
	}
	
	public Faculty(Object fid)
	{
		id=(String)fid;
		System.out.println("in faculty constructor id=" + id);
	}
	
	
	static int uploadLink(Object id,Link l)
	{
			int i=0,j=1;
		System.out.println("in upload class");
		//Object id= session.getAttribute("userid");
		//String id=request.getParameter("userid");
		System.out.println("id = " + id);
		
		try
		{
			
			 	Class.forName("com.mysql.jdbc.Driver");
			    Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/test",
			            "root", "arushi");
			    Statement st = con.createStatement();
			
		if(l.description !="" && l.url != "")
			    i = st.executeUpdate("insert into upload (id,description,link,uploadate) values('" + id + "','" + l.description + "','" + l.url + "', CURDATE())");
			
			    
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
		return i;
	}
	
	static int details(Object userid,String e,String c)
	{
		int i=0,j=1;
		try{
		// here we will update the details of faculty ! and return nothing because details.jsp is using userid which is constant
		Class.forName("com.mysql.jdbc.Driver");
	    Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/test",
	            "root", "arushi");
	    Statement st = con.createStatement();
	    System.out.println("e=" + e + " c=" + c);
	    
	    if(e!=null && e != "" && e.indexOf("@gmail.com") >= 0)
	    	i = st.executeUpdate("Update faculty set email='" + e + "' where id= '" + userid + "'");
	    else
	    		j=0;
		
	    
	    if(c!=null && c != "" && c.length()==10 )
	    	i = st.executeUpdate("Update faculty set contact='" + c + "' where id= '" + userid + "'");
	    else 
	    	j=0;
		}
		
		catch(Exception e1)
		{
			System.out.println(e1.getMessage());
		}
	
	     
	     return j;
		
	}
	
	static int InsertQuestion(Object fid,Object testid,Question q1)
	{
		int i=0;
		
		try{
			// here we will update the details of faculty ! and return nothing because details.jsp is using userid which is constant
			Class.forName("com.mysql.jdbc.Driver");
		    Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/test",
		            "root", "arushi");
		    Statement st = con.createStatement();
		    System.out.println("question is =" + q1.ques);
		    int ans=Integer.parseInt(q1.ans);
		    if(ans>=0 && ans  <= 4)		    
		    	i = st.executeUpdate("Insert into questions values('" + fid + "','" + testid +"','" + q1.ques + "','" + q1.option1 + "','" + q1.option2 + "','" + q1.option3 + "','" + 
		    						q1.option4 + "','" + q1.ans + "')" );
		}
			
			catch(Exception e1)
			{
				System.out.println(e1.getMessage());
			}
		
		
		
		return i;
	}
	

	
}
