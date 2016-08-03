<%@ page language="java" contentType="text/html; 	charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="cf"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01   
       Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link href="<c:url value="/resources/css/style.css" />" rel="stylesheet" type="text/css">

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Merchant List</title>
</head>
<body>
	<h1>Add Category</h1>
	<cf:form method="POST" action="addCategory" modelAttribute="category">
		<cf:hidden path="id" />
		<table>
			<tr>
				<td><cf:label path="name">Name</cf:label></td>
				<td><cf:input path="name" /><br /> <cf:errors path="name"
						cssClass="error" /></td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" value="Submit" /></td>
			</tr>
		</table>
	</cf:form>
</body>
</html>
