<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="utf-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ include file="/view/header.jsp" %>  

			<div class="row">
				<div class="col-md-12">
					<div class="panel panel-default">
						<div class="panel-body">
							<ol class="breadcrumb">
							  <li><a href="competence">&larr; Retour à la liste</a></li>
							</ol>
							<h2>${secteur.nom}</h2>
							<div class="panel panel-default">
								<div class="panel-heading">
									<h3 class="panel-title">Liste des missions dans ce secteur</h3>
								</div>
								<table class="table table-hover">
									<thead>
										<th>Id</th>
										<th>Intitulé</th>
										<th>Entreprise</th>
										<th>Actions</th>
									</thead>
									<tbody>
										<tr>
											<td>1</td>
											<td>Test</td>
											<td>Test</td>
											<td>
												<a href="?action=view&recordid=${mission.id}">
													<button type="button" class="btn btn-info btn-sm">
														<span class="glyphicon glyphicon-eye-open"></span> Voir
													</button>
												</a>
												<a href="?action=delete&recordid=${mission.id}">
													<button type="button" class="btn btn-danger btn-sm">
														<span class="glyphicon glyphicon-remove"></span> Supprimer
													</button>
												</a>
											</td>
										</tr>
									</tbody>
								</table>
							</div>
						</div>
					</div>
				</div>
			</div>

<%@ include file="/view/footer.jsp" %> 