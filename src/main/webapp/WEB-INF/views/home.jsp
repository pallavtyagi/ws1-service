<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ page session="false" %>
<html>
<head>
	<title>ws1-services</title>
</head>
<body>
<h1>
	Welcome <sec:authentication property="principal.username" />
</h1>

<P></P>
</body>
</html>
