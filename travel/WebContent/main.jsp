<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	import="java.util.*,org.*,bean.*,javabean.*,database.*" pageEncoding="ISO-8859-1"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<%
	PostOperation dao = new PostOperation();
	ArrayList<Post> list = dao.findAll();
	Notice n = DBAdmin.readNotice();
	
%>
<body>
	<form method="post" action="MainServlet?name=${msg }">
		<input type="text" name="name" disabled value="${msg }"> 
		<input type="submit" name="new" value="new" /><br/><br/>
		topic:	
		<%=n.getTopic()
		%><br/><br/>
		scene:
		<%=n.getTitle()
		%><br/><br/>
		activity:
		<%=n.getContent()
		%><br/><br/>
			
		<table align="center" border="1" width="80%">
			<tr>
				<th>UserName</th>
				<th>ID</th>
				<th>Title</th>
				<th>Description</th>
			</tr>
			
			
			
			<%
				for (int i = 0; i < list.size(); i++) {
					Post obj = (Post) list.get(i);
			%>

			<tr>
				<td><%=obj.getName()%></td>
				<td><%=obj.getId()%></td>
				<td><%=obj.getTitle()%></td>
				<td><%=obj.getContent()%></td>
			</tr>
			<%
				}
			%>
		</table>
	</form>
</body>
</html>