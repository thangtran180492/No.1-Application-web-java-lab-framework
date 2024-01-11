<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%> 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<c:set var="data" value="Toykyo,Mumbai,London,New York"/>
	
	<h1>Split</h1>
	
	<c:set var="cities" value="${fn:split(data, ',') }"/>
	
	<h2>Cities</h2>
	<ul>
	<c:forEach var="city" items="${cities}">
		<li> ${city}</li>
	</c:forEach>
	</ul>
	<hr>
	
	<h1>Join</h1>
	<c:set var="joinString" value="${fn:join(cities, '*')}"/>
	<h2>${joinString}</h2>
</body>
</html>