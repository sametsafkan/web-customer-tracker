<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>List Of Customers</title>
<link type="text/css" rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/style.css" />
</head>
<body>
	<div id="wrapper">
		<div id="header">
			<h2>CRM - Customer Relation Manager</h2>
		</div>
	</div>
	<div id="container">
		<div id="content">
			<input type="button" value ="Add Customer" onclick="window.location.href='showFormForAdd'; return false;"
			class = "add-button"/>
			<table>
				<tr>
					<th>First Name</th>
					<th>Last Name</th>
					<th>E-Mail</th>
					<th>Action</th>
				</tr>
				<c:forEach var="temp" items="${customerList}">
				<c:url var="updateLink" value="showFormForUpdate">
					<c:param name="customerId" value="${temp.id}"></c:param>
				</c:url>
					<tr>
						<td>${temp.firstName}</td>
						<td>${temp.lastName}</td>
						<td>${temp.email}</td>
						<td><a href="${updateLink}">UPDATE</a></td>
					</tr>
				</c:forEach>
			</table>
		</div>
	</div>
</body>
</html>