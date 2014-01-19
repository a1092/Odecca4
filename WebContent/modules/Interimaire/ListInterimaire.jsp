<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ include file="/view/header.jsp" %>  

			<div class="row">
				<div class="col-md-12">
					<div class="panel panel-default">
						<div class="panel-body">
							<h2>Liste des intérimaires</h2>
							<p class="text-center">
								<a href="/Odecca4/app/interimaire?action=new">
									<button type="button" class="btn btn-default">
										<span class="glyphicon glyphicon-plus"></span> Ajouter un intérimaire
									</button>
								</a>
							</p>
							<table class="table table-hover">
								<thead>
									<th>#</th>
									<th>Nom</th>
									<th>Prénom</th>
									<th>Date de naissance</th>
									<th>Statut</th>
									<th>Missions effectuées</th>
									<th>Actions</th>
								</thead>
								<tbody>
									<c:forEach var="interimaire" items="${interimairelist}" >
									<tr>
										<td>${interimaire.id}</td>
										<td>${interimaire.nom}</td>
										<td>${interimaire.prenom}</td>
										<td>${interimaire.naissance}</td>
										<td><span class="label label-success">${interimaire.statut}</span></td>
										<td><span class="badge">${interimaire.nbmissions}</span></td>
										<td>
											<a href="?action=view&recordid=${interimaire.id}">
												<button type="button" class="btn btn-info btn-sm">
													<span class="glyphicon glyphicon-eye-open"></span> Voir
												</button>
											</a>
											<a href="?action=edit&recordid=${interimaire.id}">
												<button type="button" class="btn btn-warning btn-sm">
													<span class="glyphicon glyphicon-pencil"></span> Modifier
												</button>
											</a>
											<a href="?action=delete&recordid=${interimaire.id}">
												<button type="button" class="btn btn-danger btn-sm">
													<span class="glyphicon glyphicon-remove"></span> Supprimer
												</button>
											</a>
										</td>
									</tr>
									</c:forEach>
								</tbody>
							</table>
						</div>
					</div>
				</div>
			</div>

<%@ include file="/view/footer.jsp" %> 