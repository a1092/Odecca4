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



<c:choose>
    <c:when test="${account.id == 0}">
        <h1>Nouvelle entreprise</h1>
    </c:when>
    <c:otherwise>
        <h1>Modification d'une entreprise</h1>
    </c:otherwise>
</c:choose> 
 
<form method="POST" action="/Odecca4/app/account">
	
	<input type="hidden" name="action" value="save" />
	<input type="hidden" name="id" value="${account.id}" />
	<div>
		<label>Nom</label>
		<input type="text" name="nom" value="${account.nom}" />
	</div>
	<div>
		<label>Siret</label>
		<input type="text" name="siret" value="${account.siret}" />
	</div>
	<div>
		<label>Adresse</label>
		<textarea name="adresse">${account.adresse}</textarea>
	</div>
	
	<input type="submit" value="Enregistrer" />
</form>
</body>
</html>