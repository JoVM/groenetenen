<%@page contentType='text/html' pageEncoding='UTF-8' session='false'%>
<%@taglib prefix='c' uri='http://java.sun.com/jsp/jstl/core'%>
<%@taglib prefix='v' uri='http://vdab.be/tags'%>
<!doctype html>
<html lang='nl'>
<head>
<v:head title='Filiaal ${param.naam} verwijderd' />
</head>
<body>
	<v:menu />
	<h1>Het filiaal ${param.naam} is verwijderd.</h1>
</body>
</html>