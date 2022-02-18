<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
</head>
<body>


	<h2>List All Users</h2>
	
	<br>
	<a href="newcustomer">Add Customer</a>
	<br>

	<table border="1">
		<tr>
			<td>CustomerId</td>
			<td>FirstName</td>
			<td>Email</td>
			<td>Password</td>
			<td>Balance</td>
		</tr>
		<c:forEach items="${customers}" var="c">
			<tr>
				<td>${c.customerId}</td>
				<td>${c.firstName}</td>
				<td>${c.email}</td>
				<td>${c.password}</td>
				<td>${c.balance}</td>

			</tr>
		</c:forEach>
	</table>

</body>
</html>