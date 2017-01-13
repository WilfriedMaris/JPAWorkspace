<%@ page session="false" contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="vdab"  uri="http://vdab.be/tags"%>
<!DOCTYPE html>
<html lang='nl'>
<head>
	<vdab:head title="Voornamen"/>
</head>
<body>
	<vdab:menu/>
	<h1>Docenten voornamen</h1>
	<ul class='zonderbolletjes'>
		<c:forEach items='${voornamen}' var='voornaamEnId'>
			<c:url value='/docenten/zoeken.htm' var='docentURL'>
				<c:param name="id" value="${voornaamEnId.id}"/>
			</c:url>
			<li style="font-size:${voornaamEnId.voornaam.length() mod 3 + 1}em;">
				<a href='${docentURL}'>${voornaamEnId.voornaam}</a></li>
		</c:forEach>
	</ul>
</body>
</html>