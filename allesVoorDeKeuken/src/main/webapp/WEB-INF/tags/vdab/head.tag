<%@tag description = 'head van pagina' pageEncoding='UTF-8'%>
<%@attribute name='titel' required = 'true' type='java.lang.String'%>
<%@taglib prefix = 'c' uri = 'http://java.sun.com/jsp/jstl/core' %>
<title>${titel}</title>
<link rel ='icon' href='<c:url value="/images/favicon.ico"/>'/>
<meta name='viewport' content='width=device-width,initial-scale=1'>
<link rel='stylesheet' href='<c:url value="/styles/default.css"/>'>
