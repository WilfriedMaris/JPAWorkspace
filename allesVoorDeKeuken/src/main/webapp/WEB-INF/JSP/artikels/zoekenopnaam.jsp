<%@ page contentType="text/html" pageEncoding="UTF-8" session="false"%>
<%@ taglib prefix="vdab" uri="http://vdab.be/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html lang="nl">
<head>
<vdab:head titel="Artikel op naam zoeken"></vdab:head>
<style>
td {
	text-align: right;
}

td:nth-child(2) {
	text-align: left;
}
</style>
<head>
<body>
	<h1>Artikels zoeken op naam</h1>
	<form>
		<label>Naam: <span>${fouten.woord}</span> <input type="search"
			value='${param.woord}' name="woord" required autofocus>
		</label> <input type="submit" value="Zoeken">
	</form>
	<c:if test="${not empty param and empty fouten and empty artikels}">
		Geen artikels gevonden
	</c:if>
	<c:if test="${not empty artikels}">
		<table>
			<thead>
				<tr>
					<th>Nummer</th>
					<th>Naam</th>
					<th>Aankoopprijs</th>
					<th>Verkoopprijs</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="naam" items="${artikels}">
					<tr>
						<td>${naam.id}</td>
						<td>${naam.naam}</td>
						<td><fmt:formatNumber minFractionDigits="2"
								maxFractionDigits="2" value="${naam.aankoopprijs}" /></td>
						<td><fmt:formatNumber minFractionDigits="2"
								maxFractionDigits="2" value="${naam.verkoopprijs}" /></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</c:if>
</body>
</html>