<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>

<html>
<head>
<title>Login Trader</title>
</head>
<body>
	<form action="/utente/modificaPswControl" method="POST">
		<h2>Reimposta Password Utente</h2>
		<input type="text" name="username" placeholder="Inserisci Username"
			required /><br> <input type="text" name="newpassword"
			placeholder="Nuova Password" required /><br>
		<button type="submit" value="Login" name="pulsante">Salva</button>
		<input type="submit" onclick="location.href='index.jsp'"
			id="login-btn" value="Back to Login" />
	</form>
</body>
</html>