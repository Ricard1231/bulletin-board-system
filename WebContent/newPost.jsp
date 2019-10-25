<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>New Post</title>
<script type="text/javascript" src="<%=request.getContextPath()%>/ckeditor4/ckeditor.js"></script>
<link rel="stylesheet" href="css/styleNewPost.css">

</head>
<body>
<div class="container">
	<div class="header">
		<%@include file="head.jsp" %>
	</div>
	
	<div class="littlebar">
		<p>Write a Post</p>
	</div>
	
	<div class="this">
	<form action="newpost" method="post">
	
	<table>
		<tr>
			<td colspan="2">
				<input type="text" name="title" placeholder="Input title">
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
		<div class="footer">
	<%@include file="foot.jsp" %>
	</div>
</div>
</body>
</html>