<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="utf-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ include file="/view/header.jsp" %>  

			<div class="row">
				<div class="col-md-12">
					<div class="panel panel-default">
						<div class="panel-body">
							<h2>Liste des compétences</h2>
							<p class="text-center">
								<a href="/Odecca4/app/competence?action=new">
									<button type="button" class="btn btn-default">
										<span class="glyphicon glyphicon-plus"></span> Ajouter une compétence
									</button>
								</a>
							</p>
							<table class="table table-hover">
								<thead>
									<th>#</th>
									<th>Nom</th>
									<th>Nombre d'intérimaires</th>
									<th>Actions</th>
								</thead>
								<tbody>
									<c:forEach var="competence" items="${competencelist}" >
									<tr>
										<td>${competence.id}</td>
										<td>${competence.nom}</td>
										<td><span class="badge">{competence.nbinterimaires}</span></td>
										<td>
											<a href="?action=view&recordid=${competence.id}">
												<button type="button" class="btn btn-info btn-sm">
													<span class="glyphicon glyphicon-eye-open"></span> Voir
												</button>
											</a>
											<a href="?action=edit&recordid=${competence.id}">
												<button type="button" class="btn btn-warning btn-sm">
													<span class="glyphicon glyphicon-pencil"></span> Modifier
												</button>
											</a>
											<a href="?action=delete&recordid=${competence.id}">
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