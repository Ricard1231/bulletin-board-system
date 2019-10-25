<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>50AP - Login</title>
<link rel="stylesheet" href="css/styleLogin.css">
</head>
<body id="reg">
	<div id="container" class="container">
	<div class="header">
		<%@include file="head.jsp" %>
	</div>

	<div class="loginForm">
	<p class="title">Admin Login</p>
	
	<form action="adminlogin" method="post" >
	<input type="text" id="username" name="username" placeholder="Username" /><br>
	<input type="password" id="password" name="password" placeholder="Password" /><br>
	
	<input type="submit" value="Login" />&nbsp;
	<input type="reset" value="Reset" />
	
	</form>
	</div>
		<div class="footer">
	<%@include file="foot.jsp" %>
	</div>
	</div>

</body>
</html>