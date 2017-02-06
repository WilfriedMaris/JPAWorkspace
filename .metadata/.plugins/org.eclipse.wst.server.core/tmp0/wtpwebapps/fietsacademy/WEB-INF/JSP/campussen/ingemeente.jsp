<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="vdab"  uri="http://vdab.be/tags"%>
<!DOCTYPE html>
<html lang="nl">
<head>
	<vdab:head title="Campussen in ${empty param.gemeente ? 'een gemeente' : param.gemeente}"></vdab:head>
</head>
<body>
	<vdab:menu/>
	<h1>Campussen in ${empty param.gemeente ? 'een gemeente' : param.gemeente}</h1>
	<form>
		<label>Gemeente: <span>${fouten.gemeente}</span>
		<input name='gemeente' value='${param.gemeente}' autofocus required type="search" value="zoeken"></label>
		<input type="submit" value="zoeken">
	</form>
	<c:if test="${not empty param and empty fouten and empty campussen }">
		Geen campussen gevonden
	</c:if>
	<c:if test="${not empty campussen}">
		<ul>
			<c:forEach items="${campussen}" var="campus">
				<li>${campus.naam}: ${campus.adres.straat} ${campus.adres.huisNr}</li>
				<dl>
					<c:forEach items = "${campus.telefoonNrs}" var="telefoonNr">
						<dt>${telefoonNr.fax ? "Fax" : "Telefoon"}</dt>
						<dd>${telefoonNr.nummer} ${telefoonNr.opmerking}</dd>
					</c:forEach>
				</dl>
			</c:forEach>
		</ul>
	</c:if>
</body>
</html>