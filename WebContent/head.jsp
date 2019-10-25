<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title></title>

<link rel="stylesheet" href="css/styleHead.css">
</head>
<body>
		<div class="headContainer">
			<ul>
				<% if (session.getAttribute("user") == null){ %>
					<li><a href="adminlogin.jsp"><img src="images/key.png"></a></li>
				<%} 
				else {
				%>
					<li>welcome, <%=session.getAttribute("user")%></li>
				<%} %>
			</ul>
		</div>
		<div class="main-menu">
			<div class="logo-mm">
				<div class="big"><p>50AP</p></div>
				<div class="small"><p>an Ordinary Family Friendly Forum</p></div>
			</div> 
			
			<a href="viewAllposts"><div class="index-mm">
				<img src="images/eye.png">
				<p>WHAT'S NEW</p>
			</div></a>
			<% if (session.getAttribute("user") == null){ %>
			<a href="login.jsp"><div class="login-mm">
				<img src="images/sign-in.png">
				<p>LOGIN</p>
				</div></a>
			<%}
				else {
				%>
				<a href="logout.jsp"><div class="login-mm">
				<img src="images/sign-out.png">
				<p>LOGOUT</p>
				</div></a>
				<%} %>
			<% if (session.getAttribute("user") == null){ %>
			<a href="reg.jsp"><div class="register-mm">
				<img src="images/user-plus.png">
				<p>REGISTER</p>
			</div></a>
			<%}
			else {
				%>
				<div class="registerDisable-mm">
				<img src="images/user-plus.png">
				<p>REGISTER</p>
				</div>
			<%} %>
		
			<% if (session.getAttribute("user") == null){ %>
					<div class="newPostDisable-mm">
						<img src="images/plus.png">
						<p>NEW POST</p>
					</div>
			<%}
				else {
				%>
			<a href="newPost.jsp"><div class="newPost-mm">
				<img src="images/plus.png">
				<p>NEW POST</p>
			</div></a>
			<%} %>
		</div>
</body>
</html>