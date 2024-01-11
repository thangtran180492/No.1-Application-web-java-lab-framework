<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<%@ page import="java.util.*" %>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form action="lab-4-1-session.jsp">
		Add the item : <input type="text" name="theItem">
		<br>
		<input type="submit" value ="submit">
	</form>
	<hr>
	<ul>
		<li> <h1>item Entered</h1> </li>
		<% List<String> list = (List<String>) session.getAttribute("myToDolist");
			if(list == null){
				list = new ArrayList<String>();
				session.setAttribute("myToDolist", list);
			}
			list.add(request.getParameter("theItem"));
		%>
		<% for(String str : list){ %>
		<li> <h2><%= str %></h2> </li>
		<% } %>
	</ul>
</body>
</html>