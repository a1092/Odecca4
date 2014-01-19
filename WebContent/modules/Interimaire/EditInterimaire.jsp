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
    <c:when test="${interimaire.id == 0}">
        <h1>Nouvel interimaire</h1>
    </c:when>
    <c:otherwise>
        <h1>Modification d'un interimaire</h1>
    </c:otherwise>
</c:choose> 
 
<form method="POST" action="/Odecca4/app/interimaire">
	
	<input type="hidden" name="action" value="save" />
	<input type="hidden" name="id" value="${interimaire.id}" />
	
	<div>
		<label>Prénom</label>
		<input type="text" name="firstname" value="${interimaire.user.firstname}" />
	</div>
	
	<div>
		<label>Nom</label>
		<input type="text" name="lastname" value="${interimaire.user.lastname}" />
	</div>
	
	<div>
		<label>email</label>
		<input type="text" name="email" value="${interimaire.user.email}" />
	</div>
	
	<div>
		<label>Date de naissance</label>
		<input type="text" name="naissance" value="${interimaire.naissance}" />
	</div>
	
	<div>
		<label>Formation</label>
		<textarea name="formation">${interimaire.formation}</textarea>
	</div>
	
	<div>
		Qualification <br/>
		
		<select multiple="multiple" name="qualification">
		<c:forEach var="competence" items="${competenceslist}" >
			
			<c:set var="contains" value="false" />
			<c:forEach var="qualification" items="${interimaire.qualification}">
				<c:if test="${qualification eq competence}">
			  	  <c:set var="contains" value="true" />
			  	</c:if>
			</c:forEach>
			
			<c:choose>
		     	 <c:when test="${contains}">
			    	<option value="${competence.id}" selected>${competence.nom}</option>
			     </c:when>
			
			      <c:otherwise>
			      	<option value="${competence.id}" >${competence.nom}</option>
			      </c:otherwise>
			</c:choose>
			
		</c:forEach>
		</select>
	</div>
	
	<input type="submit" value="Enregistrer" />
</form>
</body>
</html>