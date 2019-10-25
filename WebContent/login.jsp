<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>50AP - Login</title>
<link rel="stylesheet" href="css/styleLogin.css">
</head>
<body id="reg">
	<div class="container">
	<div class="header">
		<%@include file="head.jsp" %>
		</div>
<!-- 	<div id="container" class="login-page"> -->
	<div class="loginForm">
	<p class="title">Login to your account</p>
	<form action="login" method="post" onsubmit="return formValidation();">
<!-- 	<p name="head" id="head"></p> -->
<div style="color:red">${msg}</div>
	<input type="text" id="username" name="username" placeholder="Username" /> <br>
	<input type="password" id="password" name="password" placeholder="Password" /> <br>
	
	<div class="custom-select">
		<select name="limit">
					<option value="0">Not to be Saved
					<option value="30">One month
					<option value="180">Half a year
		</select>
	</div>
	
	<input type="submit" value="Login" />
	<input type="reset" value="Reset" />
	
	<div class="optional">
		<p class="message">Not registered? <a href="reg.jsp">Create an account</a></p>
		<p class="message"><a href="forgotPass.jsp">Forgot password?</a></p>
	</div>
	
	</form>
	</div>
		<div class="footer">
	<%@include file="foot.jsp" %>	
	</div>
	</div>

</body>
<script type="text/javascript" src="js/checklogin.js"></script>
<script type="text/javascript" src="js/select.js"></script>
</html>