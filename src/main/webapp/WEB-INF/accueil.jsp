<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Accueil</title>
</head>
<body>
	<h1>Liste d'articles :</h1>
	<c:forEach var="current" items="${att_entrepots }">
		<h2>${current.nom }</h2>
		<p>${current.adresse }</p>
		<p>${current.surface }</p>
		<form method = "GET" action =${pageContext.request.contextPath}/DetailServlet>
		<input type="hidden" value="${current.id }" name="id_entrepot" />
			<input type="submit" value="Détail" name="detail" />
		</form>

		<hr>
	</c:forEach>
	<h1>Ajouter un entrepôt</h1>
	<form action="AffichageArticleServlet" method="POST">
		<input type="text" name="nom" placeholder="Nom" /> <input type="text"
			name="adresse" placeholder="adresse" /> <input type="number"
			name="surface" placeholder="surface" /> <input type="submit"
			value="Ajouter" name="ajouter" />
	</form>
</body>
</html>