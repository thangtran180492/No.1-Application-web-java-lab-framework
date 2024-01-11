<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h2 style="color: green;">Student</h2>
	<hr>
	The student is confirmed : <h3 style="color: orange;">${student.firstName} ${student.lastName}</h3>
	<br>
	
	Country : <h3 style="color: blue;">${student.country}</h3>
	<br>
	
	Favorite Languages : <h3 style="color: red;">${student.favoriteLanguage}</h3>
	<br>
	
	Operation systems :
	<ul>
		<c:forEach var="temp" items="${student.oprerationSystems}">
			<li><h3 style="color: green;">${temp}</h3></li>
		</c:forEach>
	</ul>
</body>
</html>