<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>User Manage</title>
<link rel="stylesheet" href="css/styleUserManage.css">
</head>
<body>
<div class="container">
	<div class="header">
		<%@include file="adminhead.jsp" %>
	</div>
	<div class="userList">
		<table cellspacing="0">
			<tr>
				<th>username</th>
				<th>full name</th>
				<th>email</th>
				<th>password</th>
				<th>gender</th>
				<th>date of birth</th>
				<th>action</th>
			</tr>
		<c:forEach var="user" items="${userslist}">
			<tr>
				<td>${user.username}</td>
				<td>${user.name}</td>
				<td>${user.email}</td>
				<td>${user.password}</td>
				<td>${user.gender}</td>
				<td>${user.date_of_birth}</td>
				<td><a href="userdelete?uid=${user.uid}">delete</a></td>
			</tr>
		</c:forEach>
		</table>
		<!-- <table cellspacing="0">
			<tr>
				<th>username</th>
				<th>full name</th>
				<th>email</th>
				<th>password</th>
				<th>gender</th>
				<th>date of birth</th>
				<th>action</th>
			</tr>
			<tr>
				<td>rafael12</td>
				<td>rafael</td>
				<td>rafael@domain.com</td>
				<td>1231</td>
				<td>Male</td>
				<td>12/10/1999</td>
				<td><a href="">delete</a></td>
			</tr>
		</table> -->
	</div>
	<div class="footer">
		<%@include file="foot.jsp" %>
	</div>
</div>

</body>
</html>