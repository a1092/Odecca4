<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>ListAccount</title>
</head>
<body>

	<ul>
		<li><a href="/Odecca4/app/account?action=new">New Account</a></li>
	</ul>
	
	<table>
	<tr>
		<td>#</td>
		<td>Nom</td>
		<td>Siret</td>
		<td>Adresse</td>
		<td>Actions</td>
	</tr>
	<c:forEach var="account" items="${accountlist}" >
		<tr>
			<td>${account.id}</td>
			<td>${account.nom}</td>
			<td>${account.siret}</td>
			<td>${account.adresse}</td>
			<td>
				<a href="?action=view&recordid=${account.id}">Voir</a> | 
				<a href="?action=edit&recordid=${account.id}">Modifier</a> | 
				<a href="?action=delete&recordid=${account.id}">Supprimer</a>
			</td>
		</tr>
	</c:forEach>
	</table>
</body>
</html>