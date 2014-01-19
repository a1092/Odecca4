<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="utf-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ include file="/view/header.jsp" %>  

			<div class="row">
				<div class="col-md-12">
					<div class="panel panel-default">
						<div class="panel-body">
							<c:choose>
							    <c:when test="${competence.id == 0}">
							        <h2>Nouvelle compétence</h2>
							    </c:when>
							    <c:otherwise>
							        <h2>Modification d'une compétence</h2>
							    </c:otherwise>
							</c:choose> 
							 
							<form class="form-horizontal" role="form" method="post" action="/Odecca4/app/competence">
								
								<input type="hidden" name="action" value="save" />
								<input type="hidden" name="id" value="${competence.id}" />

								<div class="form-group">
									<label for="nom" class="col-sm-2 control-label">Nom</label>
									<div class="col-sm-10">
										<input type="text" class="form-control" name="nom" placeholder="Nom" value="${competence.nom}">
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