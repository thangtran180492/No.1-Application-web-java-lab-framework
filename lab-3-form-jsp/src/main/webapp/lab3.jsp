<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>input text</h1>
	<form action="lab3-output.jsp">
		First name : <input type="text" name="firstname" />
		<br/>
		Last name : <input type="text" name="lastname" />
		<br/>
		<input type="submit" name="submit" />
	</form>
	<hr>
	
	<h1>drop list</h1>
	<form action="lab3-output.jsp">
		First name : <input type="text" name="firstname2" />
		<br/>
		Last name : <input type="text" name="lastname2" />
		<br/>
		<select name="contry">
			<option>Viet name</option>
			<option>America</option>
			<option>England</option>
		</select>
		<br/>
		<input type="submit" name="submit" />
	</form>
	<hr>
	
	<h1>Radion buttons</h1>
	<form action="lab3-output.jsp">
		First name : <input type="text" name="firstname3" />
		<br/>
		Last name : <input type="text" name="lastname3" />
		<br/>
		Progamming Languages :
		Java <input type="radio" name="languages" value="Java">
		Javascript <input type="radio" name="languages" value="Javascript"> 
		C <input type="radio" name="languages" value="C">  
		<br/>
		<input type="submit" name="submit" />
	</form>
	<hr>
	
	<h1>checkbox buttons</h1>
	<form action="lab3-output.jsp">
		First name : <input type="text" name="firstname4" />
		<br/>
		Last name : <input type="text" name="lastname4" />
		<br/>
		Progamming Languages :
		Java <input type="checkbox" name="addlanguages" value="Java">
		Javascript <input type="checkbox" name="addlanguages" value="Javascript"> 
		C <input type="checkbox" name="addlanguages" value="C">  
		PHP <input type="checkbox" name="addlanguages" value="PHP">
		<br/>
		<input type="submit" name="submit" />
	</form>
	<hr>
</body>
</html>