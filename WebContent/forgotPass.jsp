<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>50AP - Forgot Password</title>
<link rel="stylesheet" href="css/styleLogin.css"/>
</head>
<body>
	<div class="container">
	<div class="header">
		<%@include file="head.jsp" %>
	</div>
	
	<div style="color:red">${msg}</div>
	<div class="loginForm">
	<p class="title">Reset password</p>
	
	<form action='ForgotPassServlet' method='post'>
		<input type="text" name='chEmail' placeholder="Email Address"/> <br>
		<input type="password" name='newpass' placeholder="New Password"/> <br>
		<input type="password" name='renewpass' placeholder="Confirm Password"/> <br>
		<input type="submit" value="Change Password" />
		
		<!-- <table align="center">
			<tr>
				<td colspan="2"><input type="text" name='chEmail' placeholder="Email Address"/></td>
			</tr>
			<tr>
				<td colspan="2"><input type="password" name='newpass' placeholder="New Password"/></td>
			</tr>
			<tr>
				<td colspan="2"><input type="password" name='renewpass' placeholder="Confirm Password"/></td>
			</tr>
			<tr>
				<td colspan="2">
					<input type="submit" value="Reset Password">
				</td>
			</tr>
		</table> -->
	</form>
	</div>
		<div class="footer">
	<%@include file="foot.jsp" %>
	</div>
	</div>

</body>
</html>