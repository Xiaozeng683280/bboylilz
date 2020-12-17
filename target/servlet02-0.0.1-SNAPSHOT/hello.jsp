<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
</head>
<body>
	Hello World!<br>
	time=<%=new Date() %><br>
	1+2=<%= 1+2 %><br>
	
	<% for(int i=1;i<=10;i++){ %>
		Hello JSP!<br>	
	<% } %>	
	
</body>
</html>







