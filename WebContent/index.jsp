<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>LogIn</title>
</head>
<body>

	<form method="post" action="/Faculty/loginPath">
		<center>
			<table border="1" width="30%" cellpadding="3">
				<thead>
					<tr>
						<th colspan="2">Login Here</th>
					</tr>
				</thead>
				<tbody>
					<tr>
						<td>User ID</td>
						<td><input type="text" name="userid" value="" /></td>
					</tr>
					<tr>
						<td>Password</td>
						<td><input type="password" name="pass" value="" /></td>
					</tr>
					
					<tr><th colspan="2">
					Profession:<br>
					<input type="radio" name="prof" value="Student">Student</input>	<br>
					<input type="radio" name="prof" value="Faculty">Faculty</input> <br>
					<input type="radio" name="prof" value="Admin">Admin</input> <br>
					</th>
					</tr>
					
					<tr>
						<td><input type="submit" value="Login" /></td>
						<td><input type="reset" value="Reset" /></td>
					</tr>
					
					
				</tbody>
			</table>
		</center>
	</form>


</body>
</html>