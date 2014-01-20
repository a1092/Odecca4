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
              
              <h3>Mes missions terminées</h3>
              </c:if>
            </div>
          </div>
        </div>
      </div>
<%@ include file="/view/footer.jsp" %>