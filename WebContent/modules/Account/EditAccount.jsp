<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ include file="/view/header.jsp" %>  

			<div class="row">
				<div class="col-md-12">
					<div class="panel panel-default">
						<div class="panel-body">
							<c:choose>
							    <c:when test="${account.id == 0}">
							        <h2>Nouvelle entreprise</h2>
							    </c:when>
							    <c:otherwise>
							        <h2>Modification d'une entreprise</h2>
							    </c:otherwise>
							</c:choose> 
							 
							<form class="form-horizontal" role="form" method="post" action="/Odecca4/app/account">
								
								<input type="hidden" name="action" value="save" />
								<input type="hidden" name="id" value="${account.id}" />

								<div class="form-group">
									<label for="nom" class="col-sm-2 control-label">Nom</label>
									<div class="col-sm-10">
										<input type="text" class="form-control" id="nom" placeholder="Nom" value="${account.nom}">
									</div>
								</div>
								<div class="form-group">
									<label for="siret" class="col-sm-2 control-label">SIRET</label>
									<div class="col-sm-10">
										<input type="text" class="form-control" id="siret" placeholder="SIRET" value="${account.siret}">
									</div>
								</div>
								<div class="form-group">
									<label for="nom" class="col-sm-2 control-label">Adresse</label>
									<div class="col-sm-10">
										<textarea class="form-control" rows="3" id="adresse">${account.adresse}</textarea>
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