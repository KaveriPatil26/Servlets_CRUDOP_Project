<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.List"%>
<%@ page import="servlet_crud.dto.StudentDto"%>


<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Fetching All</title>
</head>

<body>
	<%
	List<StudentDto> l = (List<StudentDto>) request.getAttribute("object");
	%>
	<table border="">
		<tr>
			<th>Id</th>
			<th>Name</th>
		</tr>

		<%
		for (StudentDto a : l) {
		%>
		<tr>
			<td><%=a.getId()%></td>
			<td><%=a.getSname()%></td>
		</tr>
		<%
		}
		%>

	</table>
</body>
</html>