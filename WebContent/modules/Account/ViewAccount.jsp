<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ include file="/view/header.jsp" %>  

			<div class="row">
				<div class="col-md-12">
					<div class="panel panel-default">
						<div class="panel-body">
							<ol class="breadcrumb">
							  <li><a href="account">&larr; Retour à la liste</a></li>
							</ol>
							<h2>${account.nom} <small>[${account.siret}]</small></h2>
							<p>${account.adresse}</p>
						</div>
					</div>
				</div>
			</div>

<%@ include file="/view/footer.jsp" %> 