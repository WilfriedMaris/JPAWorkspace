<%@page contentType="text/html" pageEncoding="UTF-8" session="false"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://vdab.be/tags" prefix="vdab" %>
<!doctype html>
<html lang='nl'>
<vdab:head titel="Artikels"/>
<vdab:menu/>
<body>
	<h1>Artikels:</h1>
	<form>
		<label>Artikelnummer:<span>${fout}</span>
			<input name="id" type="number" required autofocus min='1' value='${param.id}'>
			<input type="submit" value="Zoeken">
		</label>
		<c:choose>
			<c:when test="${empty param.id}"></c:when>
			<c:when test="${empty fout and not empty artikel}">
				<p>
					Naam: ${artikel.naam}<br>
					Aankoopprijs: ${artikel.aankoopprijs}<br>
					Verkoopprijs: ${artikel.verkoopprijs}<br>
					Winst: ${(artikel.verkoopprijs - artikel.aankoopprijs) / artikel.aankoopprijs * 100}%<br>
				</p>
			</c:when>
			<c:otherwise>
				<p>Artikel niet gevonden.<p>
			</c:otherwise>
		</c:choose>
	</form>
</body>
</html>