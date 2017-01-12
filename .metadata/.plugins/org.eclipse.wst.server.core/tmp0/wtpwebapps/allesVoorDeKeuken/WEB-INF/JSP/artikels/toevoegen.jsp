<%@page contentType="text/html" pageEncoding="UTF-8" session="false"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://vdab.be/tags" prefix="vdab" %>
<!doctype html>
<html lang='nl'>
<vdab:head titel="Artikels toevoegen"/>
<vdab:menu/>
<body>
	<h1>Toevoegen:</h1>
	<form method="post">
		<label>Artikelnaam:<span>${fouten.naam}</span>
			<input name="naam" required autofocus value='${artikel.naam}'>
		</label>
		<label>Aankoopprijs:<span>${fouten.aankoopprijs}</span>
			<input name="aankoopprijs" type="number" required value='${artikel.aankoopprijs}'>
		</label>
		<label>Verkoopprijs:<span>${fouten.verkoopprijs}</span>
			<input name="verkoopprijs" type="number" required value='${artikel.verkooppprijs}'>
		</label>
			<input type="submit" value="Toevoegen">
	</form>
	<script>
		document.getElementById('toevoegform').onsubmit= function(){
			document.getElementById('toevoegform').disabled=true;
		};
	</script>
</body>
</html>