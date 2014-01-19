<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<ul>
		<li><a href="/Odecca4/app/interimaire?action=new">New interimaire</a></li>
	</ul>
	
	<table>
	<tr>
		<td>#</td>
		<td>Nom</td>
		<td>Prénom</td>
		<td>Prénom</td>
		<td>Email</td>
		<td>Date de naissance</td>
		<td>Actions</td>
	</tr>
	
	<c:forEach var="interim" items="${interimairelist}" >
		<tr>
			<td>${interim.id}</td>
			<td>${interim.user.firstname}</td>
			<td>${interim.user.lastname}</td>
			<td>${interim.user.email}</td>
			<td>${interim.formation}</td>
			<td>${interim.naissance}</td>
			
			<td>
				<a href="?action=view&recordid=${interim.id}">Voir</a> | 
				<a href="?action=edit&recordid=${interim.id}">Modifier</a> | 
				<a href="?action=delete&recordid=${interim.id}">Supprimer</a>
			</td>
		</tr>
	</c:forEach>
	</table>
</body>
</html>