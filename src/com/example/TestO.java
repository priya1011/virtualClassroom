package com.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class TestO {
	
	String fid;
	static int count=0;
	int testid;
	String desc;
	
	public TestO(String id,String des)
	{
		fid=id;
		desc=des;
		testid=count;
		count++;
	}
	
	static int AddTest(TestO t)
	{
		int i=0;
		//we will add test in test table with user id ,test id(auto increment) and test description
		//test is an object too
		//then set session's test id
		// while inserting in questions , we will insert user id,test id and questions
		
		System.out.println("in add test");
		
		try{
			// here we will update the details of faculty ! and return nothing because details.jsp is using userid which is constant
			Class.forName("com.mysql.jdbc.Driver");
		    Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/test",
		            "root", "arushi");
		    Statement st = con.createStatement();
		    System.out.println("testdesc is =" + t.desc);
		    
		    
		    i = st.executeUpdate("Insert into tests values('" + t.fid + "','" + t.testid + "','" + t.desc + "')" );
		}
			
			catch(Exception e1)
			{
				System.out.println(e1.getMessage());
			}
		
		
		
		if(i>0)
			return t.testid;
		else
			return 0;
	}
	
	static int deleteTest(TestO t)
	{
		int i=0,j=0;
		
		try{
			// here we will update the details of faculty ! and return nothing because details.jsp is using userid which is constant
			Class.forName("com.mysql.jdbc.Driver");
		    Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/test",
		            "root", "arushi");
		    Statement st = con.createStatement();
		    System.out.println("testdesc is =" + t.desc);
		    
		    
		    i = st.executeUpdate("Delete from tests where fid='" + t.fid + "' and descp = '" +t.desc +"'"  );
		    
		    ResultSet rs;
		    
	    	rs = st.executeQuery("select * from tests where fid='" + t.fid + "'and descp='" + t.desc +"'");
	    	
	    	
	    	
	    	System.out.println("fid = " + t.fid + "testid = " + t.testid);
	    	
	    	if(rs.next())
	    	{
	    		System.out.println("in rs if");
	    		
	    		t.testid=rs.getInt("testid");
	    		
	    		System.out.println("test id" + t.testid);
	    		rs = st.executeQuery("Delete from questions where id='" + t.fid + "' and testid = " +t.testid  );
	    	}
		}
			
			catch(Exception e1)
			{
				System.out.println(e1.getMessage());
			}
		
		
		
		
		
		return i;
	}

}
