<%@ page language="java" contentType="text/html;charset=UTF-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ include file="/view/header.jsp"%>

<div class="row">
	<div class="col-md-12">
		<div class="panel panel-default">
			<div class="panel-body">
				<div class="alert alert-success">Vous êtes bien connecté.</div>
				<h2>Tableau de bord</h2>
				<p>Bienvenue sur votre application intérim !</p>

				<c:if test="${sessionScope.user.role == 'INTER'}">
					<h3>Mes missions en cours</h3>

					<table class="table table-hover">
						<thead>
							<th>#</th>
							<th>Intitulé</th>
							<th>Secteur</th>
							<th>Entreprise</th>
							<th>Dates</th>
							<th>Statut mission</th>
							<th>Statut</th>
						</thead>
						<tbody>
							<c:forEach var="postulation" items="${postulation_encours}">
								<tr>
									<td>${postulation.mission.id}</td>
									<td>${postulation.mission.intitule}</td>
									<td>${postulation.mission.secteur.nom}</td>
									<td>${postulation.mission.account.nom}</td>
									<td>
										<fmt:formatDate value="${postulation.mission.debut}" pattern="dd/MM/yyyy" /> - 
										<fmt:formatDate value="${postulation.mission.fin}" pattern="dd/MM/yyyy" />
									</td>
									<td>${postulation.mission.statut}</td>
									<td>${postulation.statut}</td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
					
					<h3>Mes missions terminées</h3>
					<table class="table table-hover">
						<thead>
							<th>#</th>
							<th>Intitulé</th>
							<th>Secteur</th>
							<th>Entreprise</th>
							<th>Dates</th>
							<th>Statut mission</th>
							<th>Statut candidature</th>
						</thead>
						<tbody>
							<c:forEach var="postulation" items="${postulation_termine}">
								<tr>
									<td>${postulation.mission.id}</td>
									<td>${postulation.mission.intitule}</td>
									<td>${postulation.mission.secteur.nom}</td>
									<td>${postulation.mission.account.nom}</td>
									<td>
										<fmt:formatDate value="${postulation.mission.debut}" pattern="dd/MM/yyyy" /> - 
										<fmt:formatDate value="${postulation.mission.fin}" pattern="dd/MM/yyyy" />
									</td>
									<td>${postulation.mission.statut}</td>
									<td>${postulation.statut}</td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</c:if>
			</div>
		</div>
	</div>
</div>
<%@ include file="/view/footer.jsp"%>