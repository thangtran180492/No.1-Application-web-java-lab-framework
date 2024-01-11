<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<%@ page import="java.util.*, mysql.*" %>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>List Student : </h1><br>
	<table>
		<tr>
			<th><h2>Id</h2></th>
			<th><h2>Full name</th>
			<th><h2>Email</th>
		</tr>
		<%
			List<Student> students = (List<Student>) request.getAttribute("STUDENT_LIST");
		%>
		<% for(Student student : students){ %>
			<tr>
				<td><h3><%= student.getId() %></h3></td>
				<td><h3><%= student.getFirstname() %> <%= student.getLastname() %></h3></td>
				<td><h3><%= student.getEmail() %></h3></td>
			</tr>
		<% } %>
	</table>
</body>
</html>