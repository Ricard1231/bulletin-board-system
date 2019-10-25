<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html;charset=UTD-8">
<title>BBS-Register</title>
<link rel="stylesheet" href="css/styleREG.css">
<script type="text/javascript" src="js/checkreg.js"></script>
</head>

<body id="reg" onload="$('uname').focus();">
	<div class="container">
		<div class="header">
			<%@include file="head.jsp" %>
		</div>
		
		<div class="registerForm">
			<div id="form">
			<div id="msg" style="color:red"></div>
			<div style="color:red">${msg}</div>
			
			<h1 class="title">Fill out information</h1>
			<form action="register" method="post" onsubmit="return chkAll()">
				<table>
					<tr>
						<td class="ltd">Username*</td>
						<td><input type="text" id="uname" name="username" size="40"
							maxlength="20" id="uname" />
						</td>
					</tr>
					<tr>
						<td class="ltd">Password*</td>
						<td><input type="password" id="pw1" name="password" size="40"
							maxlength="20" id="pw1">
						</td>
					</tr>
					<tr>
						<td class="ltd">Confirm Password*</td>
						<td><input type="password" id="pw2" name="upw2" size="40"
							maxlength="20" id="pw2" />
						</td>
					</tr>
					<tr>
						<td class="ltd">Name</td>
						<td><input type="text" id="name" name="name" size="40"
							maxlength="20" id="name" />
						</td>
					</tr>
					<tr>
						<td class="ltd">Gender</td>
						<td><input type="radio" name="gender" value="male" checked />Male
							<input type="radio" name="gender" value="female" />Female</td>
					</tr>
					<tr>
						<td class="ltd">Email</td>
						<td><input type="text" name="email" size="40" id="email">
						</td>
					</tr>
					<tr>
						<td class="ltd">Birthday</td>
						<td>
							<input type="date" name="datepicker" id="datepicker">
						</td>
					</tr>
					<tr>
						<td class="ltd">Select a Image:</td>
						<td class="avatar" style="vertical-align:middle"><input type="radio"
							name="ulogo" id="ulogo" value="images/avatar-1.png" /> <img
							src="images/avatar-1.png" id="hlogo" /> <input type="radio"
							name="ulogo" id="ulogo" value="images/avatar-2.png" /> <img
							src="images/avatar-2.png" id="hlogo" /> <input type="radio"
							name="ulogo" id="ulogo" value="images/avatar-3.png" checked /> <img
							src="images/avatar-3.png" id="hlogo" /><input type="radio"
							name="ulogo" id="ulogo" value="images/avatar-7.png" checked /> <img
							src="images/avatar-7.png" id="hlogo" /><input type="radio"
							name="ulogo" id="ulogo" value="images/avatar-14.png" checked /> <img
							src="images/avatar-14.png" id="hlogo" /><input type="radio"
							name="ulogo" id="ulogo" value="images/avatar.png" checked /> <img
							src="images/avatar.png" id="hlogo" />
						</td>
					</tr>
					<tr>
						<td>&nbsp;</td>
						<td align="center"><input type="submit" value="Submit"
							name="mysubmit" />&nbsp; <input type="reset" value="Reset"/>
						</td>
					</tr>
				</table>
			</form>
		</div>
	</div>
		<div class="footer">
	<%@include file="foot.jsp" %>
	</div>
	</div>


</body>
</html>