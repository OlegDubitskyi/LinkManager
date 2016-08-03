<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%> 

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link href="<c:url value="/resources/css/style.css" />" rel="stylesheet"
	type="text/css">

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Merchant List</title>
</head>
<body>
	<div id="mvc">
		<h1><spring:message code="list.header" /></h1>
		<table>
			<tr>
				<th>Id</th>
				<th><spring:message code="list.col.name" /></th>
				<th><spring:message code="list.col.charge" /></th>
				<th><spring:message code="list.col.min" /></th>
				<th><spring:message code="list.col.bank" /></</th>
			</tr>
			<c:forEach var="merchant" items="${merchantList}">
				<tr>
					<td><c:out value="${merchant.id}" /></td>
					<td><c:out value="${merchant.name}" /></td>
					<td><c:out value="${merchant.charge}" /></td>
					<td><c:out value="${merchant.minSum}" /></td>
					<td><c:out value="${merchant.bankName}" /></td>
					<td><a href="${merchant.id}" title="Edit"><img alt="Edit"
							border="0" src="<c:url value="/resources/images/edit.ico" />"
							width="16" height="16"> </a></td>

				</tr>
			</c:forEach>
		</table>
	</div>
</body>
</html>
