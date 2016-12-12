<%@page contentType='text/html' pageEncoding='UTF-8' session='false'%>
<%@taglib prefix='c' uri='http://java.sun.com/jsp/jstl/core'%>
<%@taglib prefix='v' uri='http://vdab.be/tags'%>
<!doctype html>
<html lang='nl'>
<head>
<v:head title='Filiaal toevoegen' />
</head>
<body>
	<v:menu />
	<h1>Filiaal toevoegen</h1>
	<form method='post' action='<c:url value="/filialen"/>'>
		<input type='submit' value='Toevoegen'>
	</form>
</body>
</html>