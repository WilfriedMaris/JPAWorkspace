<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt"  uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="vdab"  uri="http://vdab.be/tags"%>
<!DOCTYPE html>
<html lang="nl">
<head>
	<vdab:head title="Docenten per campus"></vdab:head>
</head>
<body>
	<vdab:menu/>
	<h1>Docenten per campus</h1>
	<ul class = "zonderbolletjes">
		<c:forEach items="${campussen}" var="campus">
			<c:url value='' var="url">
				<c:param name="id" value="${campus.id}"/>
			</c:url>
			<li><a href="${url}">${campus.naam}</a></li>
		</c:forEach>
	</ul>
	<c:if test="${not empty campus}">
		<h2></h2>
	</c:if>
</body>
</html>