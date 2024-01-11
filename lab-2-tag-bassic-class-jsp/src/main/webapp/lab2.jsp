<html>
<%@ page import="java.util.*" %>
<%@ page import="demo.*"%>
<head>
<body>
	<ul>
		<li> <p> lab 2.1 Expression </p> </li>
		<li> <p>Today's date: <%= (new java.util.Date()).toLocaleString() %></p> </li>
	</ul>
	<hr>
	<br/>
	<ul>
		<li> <p> lab 2.2 Scriplet Element </p> </li>
		<% String outPrint = "Hello JSP!!!"; %>
		<li> <p><% out.print(outPrint); %></p> </li>
	</ul>
	<hr>
	<br/>
	<ul>
		<li> <p> lab 2.3 Declaration:</p> </li>
		<%! String makeItLower1(String data){
			return data;
			}
		%>
		<li> <p>lower case : <%= makeItLower1("Hello world") %></p> </li>
	</ul>
	<hr>
	<br/>
	<ul>
		<li> <p> lab 2.4</p> </li>
		<% Test test = new Test(); 
			test.setStr("hello"); %>
		<li> <p><%= test.getStr() %></p> </li>
	</ul>
	<hr>
	<br/>
	<ul>
		<li> <p> lab 2.5 JSP (Implicit Objects)</p> </li>
		
		<li> <p>request : </p> </li>
		<li> <p>request user agent : <%= request.getHeader("User-Agent") %></p> </li>
		<li> <p>request language : <%= request.getLocale() %></p> </li>
	</ul>
	<hr>
	<br/>
	
</body>
</html>