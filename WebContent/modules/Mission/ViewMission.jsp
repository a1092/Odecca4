<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="utf-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ include file="/view/header.jsp" %>  

			<div class="row">
				<div class="col-md-12">
					<div class="panel panel-default">
						<div class="panel-body">
							<ol class="breadcrumb">
							  <li><a href="competence">&larr; Retour à la liste</a></li>
							</ol>
							<h2>${mission.intitule} <small>[${mission.account.nom}]</small></h2>
							<div class="panel panel-default">
								<div class="panel-heading">
									<h3 class="panel-title">Informations sur la mission</h3>
								</div>
								<div class="panel-body">
									<dl class="dl-horizontal">
  										<dt>Description</dt>
  										<dd>${mission.description}</dd>
									</dl>
									<dl class="dl-horizontal">
  										<dt>Secteur</dt>
  										<dd><span class="label label-default">${mission.secteur.nom}</span></dd>
									</dl>
									<dl class="dl-horizontal">
  										<dt>Compétences requises</dt>
  										<dd>
  											<ul class="list-unstyled">
  											<c:forEach var="competence" items="${mission.competences}" >
  												<li>${competence.nom}</li>
  											</c:forEach>
  											</ul>
  										</dd>
									</dl>
									<dl class="dl-horizontal">
  										<dt>Lieu</dt>
  										<dd>${mission.lieu}</dd>
									</dl>
									<dl class="dl-horizontal">
  										<dt>Date de début</dt>
  										<dd><fmt:formatDate value="${mission.debut}" pattern="dd/MM/yyyy" /></dd>
									</dl>	
									<dl class="dl-horizontal">
  										<dt>Date de fin</dt>
  										<dd><fmt:formatDate value="${mission.fin}" pattern="dd/MM/yyyy" /></dd>
									</dl>	
									<dl class="dl-horizontal">
  										<dt>Tarif horaire</dt>
  										<dd><span class="badge">${mission.tarif} €</span></dd>
									</dl>							
								</div>
							</div>
							<div class="panel panel-default">
								<div class="panel-heading">
									<h3 class="panel-title">Liste des postulants</h3>
								</div>
								<table class="table table-hover">
									<thead>
										<th>Id</th>
										<th>Nom</th>
										<th>Prenom</th>
										<th>Email</th>
										<th>Competences</th>
										<th>Actions</th>
									</thead>
									<tbody>
										<c:forEach var="postulation" items="${postulationlist}" >
										<tr <c:if test="${postulation.statut != 'Candidature'}">class="success"</c:if>>
											<td>${postulation.id}</td>
											<td>${postulation.interimaire.user.firstname}</td>
											<td>${postulation.interimaire.user.lastname}</td>
											<td>${postulation.interimaire.user.email}</td>
											<td>
											<c:forEach var="qualification" items="${postulation.interimaire.qualification}" >
												${qualification.nom},
											</c:forEach>
											</td>
											<td>
											<c:if test="${mission.statut == 'En cours' }">
												<a href="/Odecca4/app/mission?action=missioner&interimaire=${postulation.interimaire.id}&mission=${mission.id}">
													<button type="button" class="btn btn-success btn-sm">
														<span class="glyphicon glyphicon-flash"></span> Missioner
													</button>
												</a>
											</c:if>
												<a href="/Odecca4/app/interimaire?action=view&recordid=${postulation.interimaire.id}">
													<button type="button" class="btn btn-info btn-sm">
														<span class="glyphicon glyphicon-eye-open"></span> Voir
													</button>
												</a>
												<c:if test="${mission.statut == 'En cours' }">
												<a href="#">
													<button type="button" class="btn btn-danger btn-sm">
														<span class="glyphicon glyphicon-remove"></span> Supprimer
													</button>
												</a>
												</c:if>
											</td>
										</tr>
										</c:forEach>
										
									</tbody>
								</table>
							</div>
						</div>
					</div>
				</div>
			</div>

<%@ include file="/view/footer.jsp" %> 