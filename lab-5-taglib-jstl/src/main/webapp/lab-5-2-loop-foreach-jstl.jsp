<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<%
	String[] cities = {"mumbai", "tokyo", "Lodon"};
	pageContext.setAttribute("myCities", cities);
%>
<body>
	<h1>Cities</h1>
	<ul>
	<c:forEach var="itemCity" items="${myCities}" >
		<li> ${itemCity} </li>
	</c:forEach>
	</ul>
</body>
</html>