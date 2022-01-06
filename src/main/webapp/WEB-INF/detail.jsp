<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Detail</title>
</head>
<body>
	<h1>Détail de l'entrepot ${att_entrepot.nom} :</h1>
	<c:forEach var="current" items="${att_entrepot.stocks}">
		<h2>${current.article.nom}(${current.quantite})</h2>
		<p>Prix/unité : ${current.article.prix}</p>
		<p>Pays de provenance : ${current.article.paysDeProvenance}</p>
		
		<p>Détails : ${current.article.details}</p>
		<p>Gamme : ${current.article.gamme.valeurs}</p>
		<hr>
	</c:forEach>
	<h2>Ajouter un article</h2>
	<form method="post" action="${ pageContext.request.contextPath }/DetailServlet">
		<input type="hidden" name="id_entrepot" value="${att_entrepot.id }"/>
		<div><input type="text" name="nom" placeholder="Nom" /></div>
		<div><input type="number" name="prix" placeholder="Prix" /></div>
		<div>
		<hr>
		<select name="pays">
			<c:forEach var="curPays" items="${pays }">
				<option value="${curPays }">${curPays }</option>
			</c:forEach>
		</select>
		<hr>
		<select name="gamme">
			<c:forEach var="curGamme" items="${gammes }">
				<option value="${curGamme.id }">${curGamme.valeurs }</option>
			</c:forEach>
		</select>
		</div>
		<div>
			<input type="radio" id="meuble" name="type" value="meuble" onclick="showMeuble()" >
			<label for="meuble">Meuble</label>
			<input type="radio" id="ecran" name="type" value="ecran" onclick="showEcran()" >
			<label for="ecran">Ecran</label>
		</div>
		<div id="meuble_inputs">
			<input type="number" name="longueur" placeholder="Longueur" /><br/>
			<input type="number" name="largeur" placeholder="Largeur" /><br/>
			<input type="number" name="hauteur" placeholder="Hauteur" /><br/>
		</div>
		<div id="ecran_inputs">
			<input type="checkbox" id="hdmi" name="hdmi" />
			<label for="hdmi">HDMI</label><br/>
			<input type="checkbox" id="vga" name="vga" value="VGA" />
			<label for="vga">VGA</label><br/>
			<input type="number" name="frequence" placeholder="Frequence" /><br/>
		</div>
		<input type="submit" value="Ajouter" />
	</form>
</body>
</html>