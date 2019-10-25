<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.*" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Posts</title>
<link rel="stylesheet" href="css/style.css"/>
</head>
<body>
	<div class="container">
	<%
		String message = null;
		String sessionID = null;
		Cookie[] cookies = request.getCookies();
		if (cookies != null) {
			for (Cookie cookie : cookies) {
				if (cookie.getName().equals("message"))
					message = cookie.getValue();
				if (cookie.getName().equals("JSESSIONID"))
					sessionID = cookie.getValue();
			}
		}
	%>
	<div class="header">
	<%@include file="head.jsp" %></div>
	

	<div class="content" id="content">
		<div id="postslist">
			<table id="pListTable" cellspacing="0">
				<tr class="head">
					<th class="title">Title</th>
					<th class="replies">Replies / Views</th>
					<th class="lastPost">Last Post By</th>
				</tr>
				<c:forEach var="post" items="${postslist}">
					<tr>
						<td>
							<a href="post?pid=${post.pid}" title="click">${post.pTitle}</a>
							<br>by: ${post.pAuthor}
						</td>
						<td>Replies: ${post.pReplies}<br>Views: ${post.pClicks}</td>
						<td>
							<c:choose>
								<c:when test="${post.pLastAuthor == null}">
									----</c:when>
								<c:otherwise>${post.pLastAuthor}<br>${post.pLastUpdate}</c:otherwise>
							</c:choose>
						</td>
					</tr>
				</c:forEach>
			</table>
			</div>
			</div>
			<div class="footer">
				<%@include file="foot.jsp" %>
			</div>
		</div>
</body>
</html>