<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="utf-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ include file="/view/header.jsp" %>  

			<div class="row">
				<div class="col-md-12">
					<div class="panel panel-default">
						<div class="panel-body">
							<ol class="breadcrumb">
							  <li><a href="interimaire">&larr; Retour à la liste</a></li>
							</ol>
							<h2>${interimaire.user.firstname} ${interimaire.user.lastname} <small><span class="label label-success">${interimaire.statut}</span></small></h2>
							<div class="panel panel-default">
								<div class="panel-heading">
									<h3 class="panel-title">Informations personnelles</h3>
								</div>
								<div class="panel-body">
									<p>${interimaire.adresse}</p>
								</div>
							</div>

							<div class="panel panel-default">
								<div class="panel-heading">
									<h3 class="panel-title">Historiques des missions effectuées</h3>
								</div>
								<div class="panel-body">
									<p><span class="label label-default">1</span> mission a été effectuée par cet intérimaire.</p>
								</div>
								<table class="table table-hover">
									<thead>
										<th>Entreprise</th>
										<th>Date</th>
										<th>Durée</th>
										<th>Salaire</th>
										<th>Actions</th>
									</thead>
									<tbody>
										<tr>
											<td>Test</td>
											<td>01/01/2014 - 10/01/2014</td>
											<td>10 jours</td>
											<td><span class="label label-default">1200 </span></td>
											<td>
												<a href="?action=view&recordid=${interimaire.id}">
													<button type="button" class="btn btn-info btn-sm">
														<span class="glyphicon glyphicon-eye-open"></span> Voir
													</button>
												</a>
												<a href="?action=delete&recordid=${interimaire.id}">
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
