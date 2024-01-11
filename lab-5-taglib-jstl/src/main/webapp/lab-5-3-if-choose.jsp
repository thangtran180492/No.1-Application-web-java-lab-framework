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
	<c:set var="data" value="luv2code" />
	<ul>
		<li> String :</li>
		<li> ${data}</li>
		<li> Length of String : ${fn:length(data)}</li>
		<li> Uppper of String : ${fn:toUpperCase(data)}</li>
		<li> "luv" is start of String : ${fn:startsWith(data, "luv")}</li>
	</ul>
</body>
</html>