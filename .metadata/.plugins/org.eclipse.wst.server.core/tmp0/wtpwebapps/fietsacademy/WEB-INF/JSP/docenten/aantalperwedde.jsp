<%@ page contentType="text/html" pageEncoding="UTF-8" session="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="vdab" uri="http://vdab.be/tags"%>
<!DOCTYPE html>
<html lang="nl">
<head>
<vdab:head title="Aantal docenten per wedde"></vdab:head>
</head>
<style>
td:first-child {
	padding-right: 0.5em;
	text-align: right;
}

td:nth-child(2) div {
	background: linear-gradient(to right, wheat, orange);
	padding-left: 0.5em;
}
</style>
<body>
	<vdab:menu />
	<h1>Aantal docenten per wedde</h1>
	<table>
		<thead>
			<tr>
				<th>wedde</th>
				<th>Aantal docenten</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items='${weddesEnAantallen}' var='weddeEnAantal'>
				<tr>
					<td><fmt:formatNumber value='${weddeEnAantal.wedde}'
							minFractionDigits="2" maxFractionDigits="2" /></td>
					<td><div style='width:${weddeEnAantal.aantal}'>${weddeEnAantal.aantal}</div></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</body>
</html>