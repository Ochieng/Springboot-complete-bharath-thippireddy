<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<h3>Locations</h3>
	<table>
		<tr>
			<th>ID</th>
			<th>CODE</th>
			<th>NAME</th>
			<th>TYPE</th>
			<th>Actions</th>
		</tr>

		<c:forEach items="${locations}" var="location">
			<tr>
				<td>${location.id}</td>
				<td>${location.code}</td>
				<td>${location.name}</td>
				<td>${location.type}</td>
				<td><a href="showUpdate?id=${location.id}">Update</a></td>
				<td><a href="deleteLocation?id=${location.id}">Delete</a></td>
			</tr>
		</c:forEach>
		
	</table>
	<br/>
	<a href="showCreate">Add Location</a>
</body>
</html>