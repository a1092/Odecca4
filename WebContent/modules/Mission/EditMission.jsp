<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="utf-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ include file="/view/header.jsp" %>  

			<div class="row">
				<div class="col-md-12">
					<div class="panel panel-default">
						<div class="panel-body">
							<c:choose>
							    <c:when test="${mission.id == 0}">
							        <h2>Nouvelle mission</h2>
							    </c:when>
							    <c:otherwise>
							        <h2>Modification d'un mission</h2>
							    </c:otherwise>
							</c:choose> 
							 
							<form class="form-horizontal" role="form" method="post" action="/Odecca4/app/mission">
								
								<input type="hidden" name="action" value="save" />
								<input type="hidden" name="id" value="${mission.id}" />

								<div class="form-group">
									<label for="nom" class="col-sm-2 control-label">Entreprise</label>
									<div class="col-sm-10">
										<select name="account">
											<option></option>
											<c:forEach var="account" items="${accountlist}" >
												
												<c:choose>
											     	 <c:when test="${mission.account.id eq account.id}">
												    	<option value="${account.id}" selected>${account.nom}</option>
												     </c:when>
												
												      <c:otherwise>
												      	<option value="${account.id}">${account.nom}</option>
												      </c:otherwise>
												</c:choose>
												
											</c:forEach>
											
										</select>
									</div>
								</div>
								
								
								<div class="form-group">
									<label for="secteur" class="col-sm-2 control-label">Secteur</label>
									<div class="col-sm-10">
										<select name="secteur">
											<option></option>
											<c:forEach var="secteur" items="${secteurlist}" >
												
												<c:choose>
											     	 <c:when test="${mission.secteur.id eq secteur.id}">
												    	<option value="${secteur.id}" selected>${secteur.nom}</option>
												     </c:when>
												
												      <c:otherwise>
												      	<option value="${secteur.id}">${secteur.nom}</option>
												      </c:otherwise>
												</c:choose>
												
											</c:forEach>
											
										</select>
									</div>
								</div>
								
								<div class="form-group">
									<label for="debut" class="col-sm-2 control-label">Debut</label>
									<input type="text" name="debut" value="${mission.debut}" />
								</div>
								
								<div class="form-group">
									<label for="fin" class="col-sm-2 control-label">Fin</label>
									<input type="text" name="fin" value="${mission.fin}" />
								</div>
								
								<div class="form-group">
									<label for="intitule" class="col-sm-2 control-label">Intitulé</label>
									<input type="text" name="intitule" value="${mission.intitule}" />
								</div>
								
								<div class="form-group">
									<label for="lieu" class="col-sm-2 control-label">Lieu</label>
									<input type="text" name="lieu" value="${mission.lieu}" />
								</div>
								
								<div class="form-group">
									<label for="tarif" class="col-sm-2 control-label">Tarif</label>
									<input type="text" name="tarif" value="${mission.tarif}" />
								</div>
								
								<div class="form-group">
									<label for="description" class="col-sm-2 control-label">description</label>
									<textarea name="description">${mission.description}</textarea>
								</div>
								
								
								<div class="form-group">
									<label for="competences" class="col-sm-2 control-label">Compétences</label>
									<div class="col-sm-10">
										<select multiple class="form-control" name="competences">
											<c:forEach var="competence" items="${competenceslist}" >
			
												<c:set var="contains" value="false" />
												<c:forEach var="qualification" items="${mission.competences}">
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