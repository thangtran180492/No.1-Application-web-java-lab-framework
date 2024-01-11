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
		<h3>Add Student</h3>
		<form action="StudentControlServlet" method="GEt">
			<input type="hidden" name="command" value="ADD">
			<table>
				<tbody>
					<tr> 
						<td> <label>First name : </label></td>
						<td> <input type="text" name="firstName"></td>
					</tr>
					
					<tr> 
						<td> <label>Last name : </label></td>
						<td> <input type="text" name="lastName"></td>
					</tr>
					
					
					<tr> 
						<td> <label>Email: </label></td>
						<td> <input type="text" name="email"></td>
					</tr>
					<tr> 
						<td> <input class="save" type="submit" value="Add student"></td>
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