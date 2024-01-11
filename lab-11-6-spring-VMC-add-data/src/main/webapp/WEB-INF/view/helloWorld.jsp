<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<ul>
		<li><h1>Name student</h1></li>
		<li><h2>${param.studentName}</h2></li>
		<li><h2 style="color: red;">cover : ${message}</h2></li>
	</ul>
</body>
</html>