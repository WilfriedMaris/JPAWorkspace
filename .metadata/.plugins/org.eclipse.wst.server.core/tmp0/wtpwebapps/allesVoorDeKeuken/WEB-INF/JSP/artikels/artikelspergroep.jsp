<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="vdab" uri="http://vdab.be/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html lang='nl'>
<head>
<vdab:head titel="Artikels per artikelgroep"></vdab:head>
</head>
<body>
	<vdab:menu />
	<h1>Artikels per artikelgroep:</h1>
	<c:forEach items="${artikelgroepen}" var="groep">
		<c:url value="" var="url">
			<c:param name="id" value="${groep.id}" />
		</c:url>
		<a href="${url}">${groep.naam}</a>
	</c:forEach>
	<c:if test="${not empty artikels}">
		<table>
			<thead>
				<tr>
					<th>Nummer</th>
					<th>Naam</th>
					<th>Verkoopprijs</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${artikels}" var="artikel">
					<tr>
						<th>${artikel.id}</th>
						<th>${artikel.naam}</th>
						<th><fmt:formatNumber value="${artikel.verkoopprijs}"
								minFractionDigits="2" maxFractionDigits="2" /></th>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</c:if>
</body>
</html>