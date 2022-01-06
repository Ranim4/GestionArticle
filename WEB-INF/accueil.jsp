<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="ihm.Pays"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Accueil</title>
</head>
<body>
	<h1>Liste d'articles :</h1>
	<c:forEach var="current" items="${att_articles }">
		<h2>${current.nom }</h2>
		<p>${current.prix }</p>
		<p>${current.paysDeProvenance}</p>
		<hr>
	</c:forEach>
	<h1>Ajouter un article</h1>
	<form
		action="${pageContext.request.contextPath }/AffichageArticleServlet"
		method="post">
		<input type="text" name="nom" placeholder="Nom" />
		<input type="number" name="prix" placeholder="Prix" /> 
		<label for="pays"> Pays : </label> 
		<select>
			<c:forEach var="pays" items="${att_listPays}">
				<option>${pays}</option>
			</c:forEach>
		</select>
		<input type="submit" value="Ajouter" name="ajouter" />
	</form>
</body>
</html>