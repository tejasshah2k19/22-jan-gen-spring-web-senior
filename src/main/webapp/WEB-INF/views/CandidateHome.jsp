<%@ page language="java" isELIgnored="false"
	contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
</head>
<body>
	<h2>Welcome Candidate , ${user.firstName }</h2>
	<br>

<a href="votecount">Vote Count</a> |
	<a href="givevote">Give Vote</a>|

<br>
	
	<a href="logout">Logout</a>

<br>
${msg }
</body>
</html>