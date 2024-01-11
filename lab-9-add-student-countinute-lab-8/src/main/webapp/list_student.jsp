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
	<h1>List Student : <input type="button" value="Add Student"
								onclick="window.location.href='add-student-form.jsp'; return false;"
								class="add-student-button"
							/></h1>
	<br>
	<table>
		<tr>
			<th><h2>Id</h2></th>
			<th><h2>Full name</th>
			<th><h2>Email</th>
		</tr>
		<%
			List<Student> students = (List<Student>) request.getAttribute("STUDENT_LIST");
		%>
		
		<c:forEach var="tempStudent" items="${STUDENT_LIST}">
			<c:url var="update" value="StudentControlServlet">
				<c:param name="command" value="LOAD"/>
				<c:param name="studentId" value="${tempStudent.id}"/>
			</c:url>
			<c:url var="delete" value="StudentControlServlet">
				<c:param name="command" value="DElETE"/>
				<c:param name="studentId" value="${tempStudent.id}"/>
			</c:url>
			<tr>
				<td><h3>${tempStudent.firstname}</h3></td>
				<td><h3>${tempStudent.lastname}</h3></td>
				<td><h3>${tempStudent.email}</h3></td>
				<td><h3><a href="${update}">Update</a>
				---
				<a href="${delete}"
				onclick="if(!(confirm('Are you sure you want to delete this student?'))) return false">Delete</a></h3><h3></h3></td>
				
			</tr>
		</c:forEach>
	</table>
	
</body>
</html>