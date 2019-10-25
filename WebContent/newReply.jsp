<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>New Reply</title>
<script type="text/javascript" src="<%=request.getContextPath()%>/ckeditor4/ckeditor.js"></script>

<link rel="stylesheet" href="css/newreply.css">

</head>
<body>
<div class="container">
	<div class="header">
		<%@include file="head.jsp" %>
	</div>
			<div class="littlebar">
			<p>Write a Reply</p>
		</div>
	<div class="this">
	<form action="reply" method="post">
	<input type="hidden" name="pid" value="${param.pid}">
		<table>
			<tr>
				<td colspan="2">
					<input type="text" name="title" value="${param.pTitle}" readonly>
				</td>
			</tr>
			<tr>
				<td colspan="2">
				<textarea name="message" class="ckeditor" cols="30" rows="10"></textarea>
				</td>
			</tr>
		</table>
			<div class="postButton">
				<input type="submit" value="Submit">
			</div>
			<div class="resetButton">
				<input type="reset" value="Reset">
			</div>
	</form>
	</div>
</div>
</body>
</html>