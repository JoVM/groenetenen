<%@page contentType='text/html' pageEncoding='UTF-8' session='false'%>
<%@taglib prefix='c' uri='http://java.sun.com/jsp/jstl/core'%>
<%@taglib prefix='spring' uri='http://www.springframework.org/tags'%>
<%@taglib prefix='form' uri='http://www.springframework.org/tags/form'%>
<%@taglib prefix='v' uri='http://vdab.be/tags'%>
<!doctype html>
<html lang='nl'>
<head>
<v:head title='Filialen per postcode' />
</head>
<body>
	<v:menu />
	<h1>Filialen per postcode</h1>
	<c:url value='/filialen' var='url' />
	<form:form action='${url}' commandName='postcodeReeks' method='get'>
		<form:label path='vanpostcode'>Van:</form:label>
		<form:input path='vanpostcode' autofocus='autofocus' />
		<form:label path='totpostcode'>Tot:</form:label>
		<form:input path='totpostcode' />
		<input type='submit' value='Zoeken'>
	</form:form>
	<c:forEach items='${filialen}' var='filiaal'>
		<spring:url var='url' value='/filialen/{id}'>
			<spring:param name='id' value='${filiaal.id}' />
		</spring:url>
		<h2>
			<a href='${url}'>${filiaal.naam}</a>
		</h2>
		<p>${filiaal.adres.straat}
			${filiaal.adres.huisNr}<br> ${filiaal.adres.postcode}
			${filiaal.adres.gemeente}
		</p>
	</c:forEach>
</body>
</html>