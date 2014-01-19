<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ include file="/view/header.jsp" %>  

			<div class="row">
				<div class="col-md-12">
					<div class="panel panel-default">
						<div class="panel-body">
							<h2>Liste des entreprises</h2>
							<p class="text-center">
								<a href="/Odecca4/app/account?action=new">
									<button type="button" class="btn btn-default">
										<span class="glyphicon glyphicon-plus"></span> Ajouter une entreprise
									</button>
								</a>
							</p>
							<table class="table table-hover">
								<thead>
									<th>#</th>
									<th>Nom</th>
									<th>Siret</th>
									<th>Adresse</th>
									<th>Actions</th>
								</thead>
								<tbody>
									<c:forEach var="account" items="${accountlist}" >
									<tr>
										<td>${account.id}</td>
										<td>${account.nom}</td>
										<td>${account.siret}</td>
										<td>${account.adresse}</td>
										<td>
											<a href="?action=view&recordid=${account.id}">
												<button type="button" class="btn btn-info btn-sm">
													<span class="glyphicon glyphicon-eye-open"></span> Voir
												</button>
											</a>
											<a href="?action=edit&recordid=${account.id}">
												<button type="button" class="btn btn-warning btn-sm">
													<span class="glyphicon glyphicon-pencil"></span> Modifier
												</button>
											</a>
											<a href="?action=delete&recordid=${account.id}">
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