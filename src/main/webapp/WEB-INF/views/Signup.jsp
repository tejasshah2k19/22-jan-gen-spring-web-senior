<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
</head>
<body>

	<h2>Signup</h2>



	<form action="saveuser" method="post">

		FirstName : <input type="text" name="firstName" /> <br> <BR>
		Email : <input type="text" name="email" /><br> <BR>
		Password : <input type="text" name="password" /> <br> <BR>
		IsCandidate : <input type="checkbox" name="candidate" value="true"> 
		<input type="submit" value="Signup" />


	</form>
	<br>
	<a href="login">Login</a>

</body>
</html>