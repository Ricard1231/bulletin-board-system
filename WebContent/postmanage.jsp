<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Post Manage</title>
<link rel="stylesheet" href="css/stylePostManage.css"/>
</head>
<body>
	<div class="container">
		<div class="header">
			<%@include file="adminhead.jsp" %>
		</div>
		<div class="content">
			<table cellspacing="0">
			<tr class="head">
				<th class="title">Title</th>
				<th class="replies">Replies / Views</th>
				<th class="lastPost">Last Post By</th>
				<th class="action">Action</th>
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
				<td>
					<a href="postdelete?pid=${post.pid}">delete</a>
				</td>
			</tr>
			</c:forEach>
			</table>
		</div>
		<div class="footer">
			<%@include file="foot.jsp" %>
		</div>
	</div>
</body>
</html>

<!-- OLD CODES -->
				<%-- <td><img src="images/hot_red_folder.gif" /><a
						href="post?pid=${post.pid}" title="click">${post.pTitle}</a></td>
				<td>${post.pAuthor}<br>${post.pDate}</td>
				<td>
					<c:choose>
						<c:when test="${post.pLastAuthor == null}">
						----</c:when>
					<c:otherwise>
						${post.pLastAuthor}<br>${post.pLastUpdate}
					</c:otherwise>
					</c:choose>
				</td>
				<td>${post.pReplies}</td>
				<td>${post.pClicks}</td>
				<td><a href="postdelete?pid=${post.pid}">delete</a></td> --%>