<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<div>
		<h1>Update Student : </h1>
		<form action="StudentControlServlet" method="GET">
			<input type="hidden" name="command" value="UPDATE">
			<input type="hidden" name="studentId" value="${THE_STUDENT.id}">
			<table>
				<tbody>
					<tr> 
						<td> <label>First name : </label></td>
						<td> <input type="text" name="firstName"
							        value="${THE_STUDENT.firstname}"></td>
					</tr>
					
					<tr> 
						<td> <label>Last name : </label></td>
						<td> <input type="text" name="lastName"
									value="${THE_STUDENT.lastname}"></td>
					</tr>
					
					
					<tr> 
						<td> <label>Email: </label></td>
						<td> <input type="text" name="email"
									value="${THE_STUDENT.email}"></td>
					</tr>
					<tr> 
						<td> <input class="save" type="submit" value="Update student"></td>
					</tr>
				</tbody>
			</table>
		</form>
		<br>
		<div style="clear: both;"></div>
		<a href="StudentControlServlet">Back to list</a>
	</div>
</body>
</html>