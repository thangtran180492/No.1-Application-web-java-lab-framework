<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h2 style="color: green;">From student</h2>
	<hr>
	<br>
	<form:form action="processForm" modelAttribute="student">
	
	First Name : <form:input path="firstName"/>
	<br><br>
	
	Last Name : <form:input path="lastName"/>
	<br><br>
	
	Country : 
	<form:select path="country">
		<form:options items="${student.countryOptions}"/>
	</form:select>
	<br><br>
	
	Favorite Languages : 
	JAVA :      <form:radiobutton path="favoriteLanguage" value="JAVA"/>
	C++ :       <form:radiobutton path="favoriteLanguage" value="C++"/>
	JAVASCRIP : <form:radiobutton path="favoriteLanguage" value="JAVASCRIP"/>
	SWIFT :     <form:radiobutton path="favoriteLanguage" value="SWIFT"/>
	PHP :       <form:radiobutton path="favoriteLanguage" value="PHP"/>
	<br><br>
	
	Operation systems : 
	Linux :     <form:checkbox path="oprerationSystems" value="Linux"/>.
	Max OS :    <form:checkbox path="oprerationSystems" value="Max OS"/>.
	MS Window : <form:checkbox path="oprerationSystems" value="MS Window"/>.
	<br><br>
	
	<input type="submit" value="submit">
	
	</form:form>
</body>
</html>