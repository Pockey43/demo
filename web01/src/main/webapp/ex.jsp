<%@page import="java.util.Random"%>
<%@ page language="java" contentType="text/html;UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%
	Random random = new Random();
	int randomInt = random.nextInt(3);
	if (randomInt ==0){
		%>
		<h1> Random Value = <%= randomInt %></h1>
<%
	} else if(randomInt ==1){
		%>
		<h1> Random Value = <%= randomInt %></h1>
<%
	} else{
		%>
		<h1> Random Value = <%= randomInt %></h1>
<%
	}

%>

<%! 
	public int sum(int a, int b){
		return a+b;
	}
%>

<h1> 1+2 = <%= sum(1,2) %></h1>



<a href="<%= request.getRequestURI() %>">click</a>
</body>
</html>