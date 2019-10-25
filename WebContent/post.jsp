<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Post</title>
<link rel="stylesheet" href="css/stylePost.css">
</head>
<body>
	<input type="hidden" name="pid" value="${param.pid}">
	
	<div class="container">
		<div class="header">
			<%@include file="head.jsp" %>
		</div>
		
		<div class="thePost">
			<div class="headBar">
					<p>${post.pDate}</p>
				</div>
				
				<div class="pUser-details">
					<div class="pUser-avatar"><img src="${user.ulogo}"></div>
					<div class="pUser-info">
						<p>${post.pAuthor}</p>
						<%-- <p>Join: ${dob}</p> --%>
						<p>${user.date_of_birth}</p>
					</div>
				</div>
				
				<div class="pContent">
					<%-- <h1>${post.pTitle}</h1> --%>
					<h1>${post.pTitle}</h1>
					<%-- <p>${post.pContent}</p> --%>
					${post.pContent}
					<div class="replyButton">
						<a href="newReply.jsp?pid=${post.pid}&pTitle=${post.pTitle}"><img src="images/reply.png"> reply</a>
					</div>
				</div>
			</div>
			
			<c:forEach var="replyuser" items="${replylist}">
			<div class="theReply">
				<div class="headBar">
					<p>${replyuser.reply.rdate}</p>
				</div>
				<div class="rContent">
					<div class="rUser-details">
						<div class="rUser-avatar">
							<img src="${replyuser.userlogo}" >
						</div>
						<p>${replyuser.reply.rauthor}</p>
					</div>
					<div class="replyContent">
						${replyuser.reply.rcontent}
					</div>
				</div>
			</div>
			</c:forEach>
	</div>
	

</body>
</html>