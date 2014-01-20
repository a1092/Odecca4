<%@ page language="java" contentType="text/html;charset=UTF-8"
    pageEncoding="utf-8" %>
    
<!DOCTYPE html>
<html>
  <head>
    <meta charset="utf-8">
    <title>Odecca</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <!-- Bootstrap -->
    <link href="/Odecca4/css/bootstrap.min.css" rel="stylesheet">
    <!-- Custom styles for this template -->
    <link href="/Odecca4/custom.css" rel="stylesheet">

    <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
      <script src="https://oss.maxcdn.com/libs/respond.js/1.3.0/respond.min.js"></script>
    <![endif]-->
  </head>
  <body>
    <div class="container">
      <div class="row header">
        <div class="col-md-4">
          <img src="/Odecca4/img/logo-odecca.png" alt="Odecca" class="img-responsive" />
        </div>
      </div>

    <nav class="navbar navbar-default" role="navigation">

      <!-- Collect the nav links, forms, and other content for toggling -->
      <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
        <ul class="nav navbar-nav">
          <li class="active"><a href="#">Accueil</a></li>
          <li class="dropdown">
            <a href="#" class="dropdown-toggle" data-toggle="dropdown">Intérimaires <b class="caret"></b></a>
            <ul class="dropdown-menu">
              <li><a href="/Odecca4/app/interimaire">Voir la liste</a></li>
              <li><a href="/Odecca4/app/interimaire?action=new">Ajouter un nouveau</a></li>
              <li class="divider"></li>
              <li><a href="/Odecca4/app/competence">Gérer les compétences</a></li>
            </ul>
          </li>
          <li class="dropdown">
            <a href="#" class="dropdown-toggle" data-toggle="dropdown">Entreprises <b class="caret"></b></a>
            <ul class="dropdown-menu">
              <li><a href="/Odecca4/app/account">Voir la liste</a></li>
              <li><a href="/Odecca4/app/account?action=new">Ajouter une nouvelle</a></li>
            </ul>
          </li>
          <li class="dropdown">
            <a href="#" class="dropdown-toggle" data-toggle="dropdown">Missions <b class="caret"></b></a>
            <ul class="dropdown-menu">
              <li><a href="/Odecca4/app/mission">Voir la liste</a></li>
              <li><a href="/Odecca4/app/mission?action=new">Ajouter une nouvelle</a></li>
              <li class="divider"></li>
              <li><a href="/Odecca4/app/secteur">Gérer les secteurs</a></li>
            </ul>
          </li>
        </ul>

        <ul class="nav navbar-nav navbar-right">
          <li><p class="navbar-text">Welcome, ${sessionScope.user.firstname} ${sessionScope.user.lastname} !</p></li>
          <li><a href="/Odecca4/logout">Déconnexion</a></li>
        </ul>
      </div>
    </nav>