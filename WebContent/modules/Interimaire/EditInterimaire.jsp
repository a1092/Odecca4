<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="utf-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ include file="/view/header.jsp" %>  

			<div class="row">
				<div class="col-md-12">
					<div class="panel panel-default">
						<div class="panel-body">
							<c:choose>
							    <c:when test="${interimaire.id == 0}">
							        <h2>Nouvel intérimaire</h2>
							    </c:when>
							    <c:otherwise>
							        <h2>Modification d'un intérimaire</h2>
							    </c:otherwise>
							</c:choose> 
							 
							<form class="form-horizontal" role="form" method="post" action="/Odecca4/app/interimaire">
								
								<input type="hidden" name="action" value="save" />
								<input type="hidden" name="id" value="${interimaire.id}" />

								<div class="form-group">
									<label for="prenom" class="col-sm-2 control-label">Prénom</label>
									<div class="col-sm-10">
										<input type="text" class="form-control" name="firstname" placeholder="Prénom" value="${interimaire.user.firstname}">
									</div>
								</div>
								<div class="form-group">
									<label for="nom" class="col-sm-2 control-label">Nom</label>
									<div class="col-sm-10">
										<input type="text" class="form-control" name="lastname" placeholder="Nom" value="${interimaire.user.lastname}">
									</div>
								</div>
								<div class="form-group">
									<label for="nom" class="col-sm-2 control-label">Email</label>
									<div class="col-sm-10">
										<input type="text" class="form-control" name="email" placeholder="Email" value="${interimaire.user.email}">
									</div>
								</div>
								<div class="form-group">
									<label for="naissance" class="col-sm-2 control-label">Date de naissance</label>
									<div class="col-sm-10">
										<input type="text" class="form-control" name="naissance" placeholder="JJ/MM/AAAA" value="${interimaire.naissance}">
									</div>
								</div>
								<div class="form-group">
									<label for="nom" class="col-sm-2 control-label">Adresse</label>
									<div class="col-sm-10">
										<textarea class="form-control" rows="3" name="adresse">${interimaire.adresse}</textarea>
									</div>
								</div>
								<div class="form-group">
									<label for="competences" class="col-sm-2 control-label">Compétences</label>
									<div class="col-sm-10">
										<select multiple class="form-control" name="qualification">
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
										<span class="help-block"><span class="badge">Ctrl</span> + clic pour sélectionner plusieurs compétences</span>
									</div>
								</div>

								<p class="text-center">
									<button type="submit" class="btn btn-success">
										<span class="glyphicon glyphicon-ok"></span> Enregistrer
									</button>
								</p>
							</form>
						</div>
					</div>
				</div>
			</div>

<%@ include file="/view/footer.jsp" %>
