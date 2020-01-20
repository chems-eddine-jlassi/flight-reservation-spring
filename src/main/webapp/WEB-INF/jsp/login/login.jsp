<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>User Login</title>
</head>
<body>
<h1>login</h1>
<form action="login" method="post">
<pre>
<h3>User Name:</h3><input type="text" name="email" />
<h3>Password :</h3><input type="password" name="password" />
<input type="submit" value="login" />
${msg}
</pre>
</form>
</body>
</html>