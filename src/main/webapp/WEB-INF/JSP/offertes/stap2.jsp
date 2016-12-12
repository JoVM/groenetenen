<%@page contentType='text/html' pageEncoding='UTF-8' session='false'%>
<%@taglib prefix='c' uri='http://java.sun.com/jsp/jstl/core'%>
<%@taglib prefix='v' uri='http://vdab.be/tags'%>
<!doctype html>
<html lang='nl'>
<head>
<v:head title='Aanvraag offerte (stap 2)' />
</head>
<body>
	<v:menu />
	<h1>Aanvraag offerte</h1>
	<h2>Stap 2</h2>
	<form method='post'>
		<div>Hier vraag je later de oppervlakte van het gazon</div>
		<input type='submit' value='Vorige stap' name='vorige'> <input
			type='submit' value='Bevestigen' name='bevestigen'>
	</form>
</body>
</html>