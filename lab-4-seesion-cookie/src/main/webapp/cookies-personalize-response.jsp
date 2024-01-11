<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
	<%
		String favlang = request.getParameter("favoritelanguages");
		
		Cookie theCookie = new Cookie("myApp.favoritelanguages", favlang);
		
		theCookie.setMaxAge(60*3);
		
		response.addCookie(theCookie);
	%>
<body>
	<ul>
		<li> <h1>Enter programming languages</h1> </li>
		<li> <h2><%= request.getParameter("favoritelanguages") %></h2> </li>
		<li> <h2><a href="cookies-homepage.jsp"> Return home page</a></h2> </li>
	</ul>
	
</body>
</html>