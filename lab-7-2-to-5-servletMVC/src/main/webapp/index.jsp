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
	<h1>List Student :</h1>
	<table>
		<c:forEach var="student" items="${student_list}">
		<tr>
			<td> ${student.firstname} </td>
			<td> ${student.lastname} </td>
			<td> ${student.email} </td>
		</tr>
		</c:forEach>
	</table>
</body>
</html>