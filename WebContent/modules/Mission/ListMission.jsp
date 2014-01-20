<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="utf-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ include file="/view/header.jsp" %>  

			<div class="row">
				<div class="col-md-12">
					<div class="panel panel-default">
						<div class="panel-body">
							<h2>Liste des missions</h2>
							
							<c:if test="${sessionScope.user.role != 'INTER'}">
							<p class="text-center">
								<a href="/Odecca4/app/mission?action=new">
									<button type="button" class="btn btn-default">
										<span class="glyphicon glyphicon-plus"></span> Ajouter une mission
									</button>
								</a>
							</p>
							</c:if>
							<table class="table table-hover">
								<thead>
									<th>#</th>
									<th>Intitulé</th>
									<th>Secteur</th>
									<th>Entreprise</th>
									<th>Date</th>
									<th>Statut</th>
									<th>Actions</th>
								</thead>
								<tbody>
									<c:forEach var="mission" items="${missionlist}" >
									<tr>
										<td>${mission.id}</td>
										<td>${mission.intitule}</td>
										<td>${mission.secteur.nom}</td>
										<td>${mission.account.nom}</td>
										<td>
											<fmt:formatDate value="${mission.debut}" pattern="dd/MM/yyyy" /> -
											<fmt:formatDate value="${mission.fin}" pattern="dd/MM/yyyy" />
										</td>
										<td>${mission.statut}</td>
										<td>
											<c:if test="${sessionScope.user.role == 'INTER'}">
											<c:forEach var="postulation" items="${mission.postulations}" >
												${postulation.interimaire.id }
											</c:forEach>
											<a href="?action=postuler&recordid=${mission.id}&postuler=true">
												<button type="button" class="btn btn-success btn-sm">
													Postuler
												</button>
											</a>
											</c:if>
											<a href="?action=view&recordid=${mission.id}">
												<button type="button" class="btn btn-info btn-sm">
													<span class="glyphicon glyphicon-eye-open"></span>
												</button>
											</a>
											<a href="?action=edit&recordid=${mission.id}">
												<button type="button" class="btn btn-warning btn-sm">
													<span class="glyphicon glyphicon-pencil"></span>
												</button>
											</a>
											<a href="?action=delete&recordid=${mission.id}">
												<button type="button" class="btn btn-danger btn-sm">
													<span class="glyphicon glyphicon-remove"></span>
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