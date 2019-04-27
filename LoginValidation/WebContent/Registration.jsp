<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">.3
<title>User_Information</title>
</head>
<body>
	<form action="registrationPage" method="post">
		Name:<input type="text" name="name" /><br> 
		MobileNo:<input type="text" name="mobileNo" /><br> 
		EmailId:<input type="email"	name="email" /><br> 
		Password:<input type="password" name="password" /><br>
		UserId:<input type="text" name="userid" /><br>
		<input type="submit" value="Register" /><br>
	</form>
	<a href="Login.jsp">Login</a>
</body>
</html>