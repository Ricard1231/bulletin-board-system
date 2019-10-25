<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" %>
<%@ page import="java.util.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<% String name = null, namelist = "";
ArrayList<String> visitors = (ArrayList<String>)application.getAttribute("namelist");
if (visitors != null){
	Iterator<String> it = visitors.iterator();
	while (it.hasNext()){
		name = it.next();
		namelist += name + " ";
	}
	if (!namelist.equals("")){
		out.println("<p>Users online:" + namelist + "</p>");
	}
}
%>
</body>
</html>