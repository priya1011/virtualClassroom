<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Test Description</title>
</head>
<body>

<form method="post"  action="/Faculty/TestDesc">
	
	
	Test Description : <input type="text" name="testDesc" placeholder="enter about the test"  /><br><br>

	
	
	<input type="submit" value="create" />
	
	</form>


</body>

<form method="post"  action="/Faculty/TestDelete">
	
	
	Test Description : <input type="text" name="testDesc" placeholder="enter the test name"  /><br><br>

	
	<input type="submit" value="Delete" />
	
	</form>


</body>

</html>