<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="vdab" uri="http://vdab.be/tags"%>
<!DOCTYPE html>
<html lang="nl">
<head>
<vdab:head titel="Kortingen" />
</head>
<body>
	<vdab:menu />
	<h1>Kortingen!</h1>
	<ul>
		<c:forEach items="${artikels}" var="artikel">
			<c:url value="" var="url">
				<c:param name="id">${artikel.id}</c:param>
			</c:url>
			<li id="artikel"><a href="${url}"> ${artikel.naam} </a></li>
		</c:forEach>
	</ul>
	<c:if test="${not empty artikel}">
		<table>
			<thead>
				<tr>
					<th>Vanaf</th>
					<th>Korting</th>
				<tr>
			</thead>
			<tbody>
				<c:forEach items="${artikel.kortingen}" var="korting">
					<tr>
						<td>${korting.vanafAantal}</td>
						<td>${korting.kortingspercentage}%</td>
					<tr>
				</c:forEach>
			</tbody>
		</table>
	</c:if>
</body>
</html>