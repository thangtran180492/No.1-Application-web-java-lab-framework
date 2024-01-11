<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<%
	String favLang = "";
	Cookie[] cookies = request.getCookies();
	if(cookies != null){
		for(Cookie tempCookie: cookies){
			if("myApp.favoritelanguages".equals(tempCookie.getName())){
				favLang = tempCookie.getValue();
				break;
			}
		}
	}
%>
<body>
	
	<ul>
		<li> <h1>Latest News report for : <%= favLang %></h1> </li>
		<li> <h2><%= favLang %></h2> </li>
	</ul>
</body>
</html>