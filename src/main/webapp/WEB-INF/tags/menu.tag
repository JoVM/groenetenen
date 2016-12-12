<%@ tag language="java" pageEncoding="UTF-8"%>
<%@taglib prefix='c' uri='http://java.sun.com/jsp/jstl/core'%>
<nav>
	<ul>
		<li><a href="<c:url value='/'/>">&#8962;</a></li>
		<li><a href="#">Filialen</a>
			<ul>
				<li><a href="<c:url value='/filialen'/>">Lijst</a></li>
				<li><a href="<c:url value='/filialen/toevoegen'/>">Toevoegen</a></li>
				<li><a href="<c:url value='/filialen/perpostcode'/>">Per
						postcode</a></li>
				<li><a href="<c:url value='/filialen/perid'/>">Per id</a></li>
				<li><a href="<c:url value='/filialen/afschrijven'/>">Afschrijven</a></li>
			</ul></li>
		<li><a href="#">Werknemers</a>
			<ul>
				<li><a href="<c:url value='/werknemers'/>">Lijst</a></li>
			</ul></li>
		<li><a href="#">Offertes</a>
			<ul>
				<li><a href="<c:url value='/offertes/aanvraag'/>">Aanvraag</a></li>
			</ul></li>
		<c:if test='${pageContext.response.locale.language != "nl"}'>
			<c:url value='' var='nederlandsURL'>
				<c:param name='locale' value='nl_be' />
			</c:url>
			<li><a href='${nederlandsURL}'>Nederlands</a></li>
		</c:if>
		<c:if test='${pageContext.response.locale.language != "en"}'>
			<c:url value='' var='engelsURL'>
				<c:param name='locale' value='en_us' />
			</c:url>
			<li><a href='${engelsURL}'>Engels</a></li>
		</c:if>
	</ul>
</nav>
