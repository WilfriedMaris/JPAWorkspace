<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="vdab" uri="http://vdab.be/tags"%>
<!DOCTYPE html>
<html lang="nl">
<head>
<vdab:head titel="Artikellijst" />
</head>
<body>
	<vdab:menu />
	<table>
		<thead>
			<tr>
				<th>Artikel</th>
				<th>ArtikelGroep</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${artikels}" var="artikel">
				<tr>
				<td>${artikel.naam}</td>
				<td>${artikel.artikelgroep.naam}</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</body>
</html>