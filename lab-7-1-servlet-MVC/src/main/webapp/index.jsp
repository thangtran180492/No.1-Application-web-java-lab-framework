<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<ul>
	<li> <h1> List Student : </h1> </li>
	<c:forEach var="student" items="${student_list}">
		<li> <h2> ${student}</h2> </li>
	</c:forEach>
	</ul>
</body>
</html>