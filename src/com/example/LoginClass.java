package com.example;

import java.io.*;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.sql.*;


public class LoginClass {

	static int check(Faculty f)
	{
		
		System.out.println("in loginClass");
		int i=0;
		
		 try{
			 
			System.out.println("in login class");
		    	
			    Class.forName("com.mysql.jdbc.Driver");
			    Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/test",
			            "root", "arushi");
			    Statement st = con.createStatement();
			    ResultSet rs;
			    
			    	rs = st.executeQuery("select * from faculty where id='" + f.id + "'and pass='" + f.password +"'");

			    
			   // rs = st.executeQuery("select * from members where id='" + userid + "' and pass='" + pwd + "and profession=" + "'" + p + "'");
			    if (rs.next()) {
			       
			       i=1; 
			        
			        System.out.println("welcome " + f.id);
			        //out.println("<a href='logout.jsp'>Log out</a>");
			   
			    }
			    }
			    catch(Exception e)
			    {
			    	System.out.println(e.getMessage());
			    }
			
		
		return i;
		
	}
}
