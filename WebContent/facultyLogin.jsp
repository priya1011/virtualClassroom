<%@  page import="java.sql.*" language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    
<!DOCTYPE html>

<html>
<head>
<title>facultyLogin</title>
<style>
body {margin:0;}

.topnav {
  overflow: hidden;
  background-color: #333;
}

.topnav a {
  float: left;
  display: block;
  color: #f2f2f2;
  text-align: center;
  padding: 14px 16px;
  text-decoration: none;
  font-size: 17px;
}

.topnav a:hover {
  background-color: #ddd;
  color: black;
}

.topnav a.active {
    background-color: #4CAF50;
    color: white;
}
</style>
<script>
function setURL(url){
    document.getElementById('iframe').src = url;
}
</script>
</head>
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
	ResultSet rs = st.executeQuery("select first_name,last_name from faculty where id='" + session.getAttribute("userid") + "'");

	while(rs.next())
	{
		session.setAttribute("first_name",rs.getString("first_name"));
		session.setAttribute("last_name",rs.getString("last_name"));
	}
%>


Welcome <%=session.getAttribute("first_name")%>
<%=session.getAttribute("last_name")%>



<a href='logout.jsp'>Log out</a>
<%
    }
%>



<div class="topnav">
<input type="button" value="Details" onclick="setURL('/Faculty/details')"/>
<input type="button" value="Upload" onclick="setURL('/Faculty/Upload')"/>
<input type="button" value="Test" onclick="setURL('/Faculty/TestDesc')"/>
 <input type="button" value="Marks" onclick="setURL('/Faculty/Marks')"/>
</div>



<iframe id="iframe" src="/Faculty/details" width="1000" height="1000">
</iframe>



</body>
</html>
