<%@ include file="/view/header.jsp" %>    
      <div class="row">
        <div class="col-md-12">
          <div class="panel panel-default">
            <div class="panel-body">
              <div class="alert alert-success">Vous êtes bien connecté.</div>
              <h2>Tableau de bord</h2>
              <p>Bienvenue sur votre application intérim !</p>
              
              <c:if test="${sessionScope.user.role == 'INTER'}">
              <h3>Mes missions en cours</h3>
              
              <table>
              	<c:forEach var="postulation" items="${postulation_encours}" >
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
              	</table>
              <h3>Mes missions terminées</h3>
              <c:forEach var="postulation" items="${postulation_termine}" >
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
              </c:if>
            </div>
          </div>
        </div>
      </div>
<%@ include file="/view/footer.jsp" %>