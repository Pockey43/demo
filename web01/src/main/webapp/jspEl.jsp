<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<jsp:useBean id="personne" class="fr.formation.inti.entity.Employee"></jsp:useBean>
<h2>Hello :</h2>


<%-- <jsp:setProperty property="firstName" name="personne" value="Aly-asgar"/> --%>

<%-- <h1> Hello ${personne.firstName} ${personne.lastName} </h1> --%>




	<form action = "emp" method = "GET">
         First Name: <input type = "text" name = "first_Name" >
         <br />
         Last Name: <input type = "text" name = "last_Name" />
         <input type = "submit" value = "Submit" />
      </form>
      
     <h1>Hello ${first_name } ${last_name }</h1>
</body>
</html>

