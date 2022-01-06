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
<form action="AffichageArticleServlet" method="POST">
	<label for="pays"> Pays : </label>
	<select>
		<c:forEach var="pays" items="${att_listPays}">
			<option>${pays}</option>
		</c:forEach>
	</select>
</form>
</body>
</html>