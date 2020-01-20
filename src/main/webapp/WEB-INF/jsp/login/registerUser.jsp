<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Register User</title>
</head>
<body>
<h1>User Registration </h1>
<br>
<form action="registerUser" method="post">
<pre>
<h3>First Name:</h3><input type="text" name="firstName" />
<h3>Last Name:</h3><input type="text" name="lastName" />
<h3>User Name:</h3><input type="text" name="email" />
<h3>Password:</h3><input type="password" name="password" />
<h3>Confirm Password:</h3><input type="password" name="confirmpassword" />
<br>
<input type="submit" value="register" />
</pre>
</form>

</body>
</html>