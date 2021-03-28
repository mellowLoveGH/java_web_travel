<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	
	<form action="NoticeServlet" method="post"> 
		topic:<br>
		<input type="text" name="topic" value="write here">
		<br>
		scene:<br>
		<input type="text" name="scene" value="write here">
		<br>
		activity:<br>
		<input type="text" name="activity" value="write here">
		<br><br>
		<input type="submit" value="Submit">
	</form> 
	
</body>
</html>