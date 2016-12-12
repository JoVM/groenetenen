<%@page contentType='text/html' pageEncoding='UTF-8' session='false'%>
<%@taglib prefix='spring' uri='http://www.springframework.org/tags'%>
<%@taglib prefix='c' uri='http://java.sun.com/jsp/jstl/core'%>
<%@taglib prefix='fmt' uri='http://java.sun.com/jsp/jstl/fmt'%>
<%@taglib prefix='v' uri='http://vdab.be/tags'%>
<!doctype html>
<html lang='nl'>
<head>
<v:head title='${filiaal.naam}' />
</head>
<body>
	<v:menu />
	<c:choose>
		<c:when test="${not empty filiaal}">
			<h1>${filiaal.naam}</h1>
			<dl>
				<dt>Straat</dt>
				<dd>${filiaal.adres.straat}</dd>
				<dt>Huisnr.</dt>
				<dd>${filiaal.adres.huisNr}</dd>
				<dt>Postcode</dt>
				<dd>${filiaal.adres.postcode}</dd>
				<dt>Gemeente</dt>
				<dd>${filiaal.adres.gemeente}</dd>
				<dt>Type</dt>
				<dd>${filiaal.hoofdFiliaal ? "Hoofdfiliaal" : "Bijfiliaal"}</dd>
				<dt>Waarde gebouw</dt>
				<dd>
					&euro;
					<fmt:formatNumber value='${filiaal.waardeGebouw}' />
				</dd>
				<dt>Ingebruikname</dt>
				<fmt:parseDate value="${filiaal.inGebruikName}" pattern="yyyy-MM-dd"
					var="inGebruikNameAlsDate" type="date" />
				<dd>
					<fmt:formatDate value='${inGebruikNameAlsDate}' type="date"
						dateStyle="short" />
				</dd>
			</dl>
			<spring:url value='/filialen/{id}/verwijderen' var='verwijderURL'>
				<spring:param name='id' value='${filiaal.id}' />
			</spring:url>
			<form action='${verwijderURL}' method='post'>
				<input type='submit' value='Verwijderen'>
			</form>
		</c:when>
		<c:otherwise>
			<div class='fout'>Filiaal niet gevonden</div>
		</c:otherwise>
	</c:choose>
	<c:if test='${not empty param.fout}'>
		<div class='fout'>${param.fout}</div>
	</c:if>
</body>
</html>