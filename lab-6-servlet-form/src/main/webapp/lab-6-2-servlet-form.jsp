<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form action="${pageContext.request.contextPath}/StudentServlet" method="GET">
		First name : <input type="text" name="firstname" />
		<br>
		
		Last name : <input type="text" name="lastname" />
		<br>
		
		<input type="submit" value="Submit"/>
	</form>
</body>
</html>