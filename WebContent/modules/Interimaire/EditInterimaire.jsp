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
										<input type="text" class="form-control" id="prenom" placeholder="Prénom" value="${interimaire.prenom}">
									</div>
								</div>
								<div class="form-group">
									<label for="nom" class="col-sm-2 control-label">Nom</label>
									<div class="col-sm-10">
										<input type="text" class="form-control" id="nom" placeholder="Nom" value="${interimaire.nom}">
									</div>
								</div>
								<div class="form-group">
									<label for="naissance" class="col-sm-2 control-label">Date de naissance</label>
									<div class="col-sm-10">
										<input type="text" class="form-control" id="siret" placeholder="JJ/MM/AAAA" value="${interimaire.naissance}">
									</div>
								</div>
								<div class="form-group">
									<label for="nom" class="col-sm-2 control-label">Adresse</label>
									<div class="col-sm-10">
										<textarea class="form-control" rows="3" id="adresse">${interimaire.adresse}</textarea>
									</div>
								</div>
								<div class="form-group">
									<label for="competences" class="col-sm-2 control-label">Compétences</label>
									<div class="col-sm-10">
										<select multiple class="form-control">
											<option>1</option>
											<option>2</option>
											<option>3</option>
											<option>4</option>
											<option>5</option>
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