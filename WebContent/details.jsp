<%@  page import="java.sql.*" language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    
<!DOCTYPE html>
<html>
<head>
<style>

</style>
</head>
<script type="text/javascript">
function fun3()
{
    var email=document.details.email.value;
    var contact=document.details.contact.value;
    
    if(email=="")
    {
        alert("First Department name must be filled");
        return false;
    }
    if(contact=="" || contact.length() !=10)
    {
    	alert("Invalid Contact Number");
        return false;
    }
}
</script>
<body>


<%
    if ((session.getAttribute("userid") == null) || (session.getAttribute("userid") == "")) {
%>
You are not logged in<br/>
<a href="index.jsp">Please Login</a>
<%} else {
	
	
	Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/test",
            "root", "arushi");
	
	Statement st = con.createStatement();
	ResultSet rs = st.executeQuery("select * from faculty where id='" + session.getAttribute("userid") + "'");
	
	
	
	while(rs.next())
	{
		session.setAttribute("first_name",rs.getString("first_name"));
		session.setAttribute("last_name",rs.getString("last_name"));
		session.setAttribute("email",rs.getString("email"));
		//session.setAttribute("password",rs.getString("password"));
		session.setAttribute("qualifications",rs.getString("qualifications"));
		session.setAttribute("subject",rs.getString("subject"));
		session.setAttribute("contact",rs.getString("contact"));
		session.setAttribute("address",rs.getString("address"));
		session.setAttribute("joining",rs.getString("joining"));
		session.setAttribute("dob",rs.getString("dob"));
	}
%>

<%
    }
%>


	
	<form method="post" onsubmit="return fun3()" action="/Faculty/details">
	
	NAME 		   : <%=session.getAttribute("first_name")%>	<%=session.getAttribute("last_name")%> <br><br>
	
	DOB			   :<%=session.getAttribute("dob")%>	<br><br>
	
	CONTACT DETAILS: <br><br>
	
	<input type="text" name="email" value="<%=session.getAttribute("email")%>"  /><br><br>

	<input type="text" name="contact" value="<%=session.getAttribute("contact")%>"  /><br><br>
	
	QUALIFICATIONS : <%=session.getAttribute("qualifications")%>	<br><br>
	
	SUBJECT		   : <%=session.getAttribute("subject")%>		<br><br>
	
	JOINING DATE   :<%=session.getAttribute("joining")%><br><br>
	
	
	<input type="submit" value="update" />
	</form>



</body>
</html>
