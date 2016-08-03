<%@ page language="java" contentType="text/html; 	charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="cf"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01   
       Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; 		charset=UTF-8">
<title>New Merchant</title>
<style>
.error {
	color: red;
	font-weight: bold;
}
</style>

</head>
<body>
	<h2>Merchant Information</h2>
	<cf:form method="POST" action="addMerchant" modelAttribute="merchant">
		<cf:hidden path="id" />
		<cf:hidden path="needToSend" />
		<cf:hidden path="sent" />
		<cf:hidden path="lastSent" />


		<table>
			<tr>
				<td><cf:label path="name">Name</cf:label></td>
				<td><cf:input path="name" /><br /> <cf:errors path="name"
						cssClass="error" /></td>


			</tr>
			<tr>
				<td><cf:label path="bankName">Bank Name</cf:label></td>
				<td><cf:input path="bankName" /><br /> <cf:errors
						path="bankName" cssClass="error" /></td>


			</tr>
			<tr>
				<td><cf:label path="swift">SWIFT Code</cf:label></td>
				<td><cf:input path="swift" /></td>
			</tr>
			<tr>
				<td><cf:label path="account">Account</cf:label></td>
				<td><cf:input path="account" /></td>
			</tr>
			<tr>
				<td><cf:label path="charge">Charge</cf:label></td>
				<td><cf:input path="charge" /></td>
			</tr>
			<tr>
				<td><cf:label path="minSum">Minimum sum</cf:label></td>
				<td><cf:input path="minSum" /></td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" value="Submit" /></td>
			</tr>
		</table>
	</cf:form>
</body>
</html>
