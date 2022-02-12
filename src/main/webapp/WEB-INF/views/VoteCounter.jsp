<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
     <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Vote Status</title>
</head>
<body>

<c:forEach items="${candidates}" var="candidate">

	${candidate.firstName} :  ${voteCounter.get(candidate.userId)}<br>

</c:forEach>
	
<br><br>

<a href="candidatehome">Back</a>
</body>
</html>