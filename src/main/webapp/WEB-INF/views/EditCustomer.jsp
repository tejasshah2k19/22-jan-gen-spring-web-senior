<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Edit Customer</title>
</head>
<body>

	<form action="updatecustomer" method="post">
		<input type="hidden" value="${customer.customerId}" name="customerId">
		FirstName : <input type="text" name="firstName"
			value="${customer.firstName}"><br>
		<BR> Email : <input type="text" name="email"
			value="${customer.email}"><br>
		<BR> Password : <input type="text" name="password"
			value="${customer.password}"><br>
		<BR> Balance : <input type="text" name="balance"
			value="${customer.balance}"><br>
		<BR> <input type="submit" value="Update customer">
	</form>
</body>
</html>