<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1 align="center">Welcome to Post</h1>
	<form action="PostServlet?user=${msg }" method="post">
		<table align="center" >
			<tr>
				<td width="66" align="right"><font size="3">User</font></td>
				<td colspan="2"><input type="text" name="user" value ="${msg }"
					style="width: 200; height: 25;" disabled/></td>
			</tr>
			<tr>
				<td width="66" align="right"><font size="3">ID</font></td>
				<td colspan="2"><input type="text" name="id"
					style="width: 200; height: 25;" /></td>
			</tr>
			<tr>
				<td width="66" align="right"><font size="3">Name</font></td>
				<td colspan="2"><input type="text" name="name"
					style="width: 200; height: 25;" /></td>
			</tr>
			<tr style="width: 200; height: 50;">
				<td align="right"><font size="3">Description</font></td>
				<td colspan="2"><input type="text" name="description"
					style="width: 200; height: 50;"/></td>
			</tr>
			<tr>
				<td colspan="3" align="center"><input type="submit"
					value="Submit" style="width: 130; height: 30;" /></td>
			</tr>
		</table>
	</form>
</body>
</html>