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
		<li><h1>lab 3.1 input text</h1> </li>
		<li><h2>Student full name :</h2> </li>
		<li><h3>${param.firstname} ${param.lastname}</h3> </li>
	</ul>
	<hr>
	<br/>
	
	<ul>
		<li><h1>lab 3.2 drop list</h1> </li>
		<li><h2>Student full name :</h2> </li>
		<li><h3>${param.firstname2} ${param.lastname2}</h3></li>
		<li><h2>Contry :</h2> </li>
		<li><h3>${param.contry} </h3></li>
	</ul>
	<hr>
	<br/>
	
	<ul>
		<li><h1>lab 3.3 Radio buttons</h1> </li>
		<li><h2>Student full name :</h2> </li>
		<li><h3>${param.firstname3} ${param.lastname3}</h3></li>
		<li><h2>Programming Languages :</h2> </li>
		<li><h3>${param.languages} </h3></li>
	</ul>
	<hr>
	<br/>
	
	<ul>
		<li><h1>lab 3.4 Checkbox</h1> </li>
		<li><h2>Student full name :</h2> </li>
		<li><h3>${param.firstname4} ${param.lastname4}</h3></li>
		<li><h2>Programming Languages :</h2> </li>
		
		<li><h3><% String[] pl = request.getParameterValues("addlanguages");
			for(String s : pl){
				out.print(s + "<br/>");
			}
		%></h3></li>
	</ul>
	<hr>
	<br/>
</body>
</html>