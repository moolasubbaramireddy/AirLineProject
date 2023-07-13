<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h2>Create A account</h2>
${error}
<form action="verifyLogin" method="post">
<pre>

EmailId <input type="text" name="emailId"/>
Password <input type="text" name="password"/>
<input type="submit" value="LOG IN"/>
</pre>
</form>
</body>
</html>