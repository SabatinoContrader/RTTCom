<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>

<html>
<head>
<title>Login Trader</title>
</head>
<body>
	<div>
		<form action="/utente/logintraderControl" method="post">
			<h3>
				username: <input type="text" name="username"
					placeholder="inserisci username">
			</h3>
			<h3>
				password: <input type="text" name="password"
					placeholder="inserisci password">
			</h3>
			<button type="submit" value="Login" name="pulsante">Login In</button>
			<input type="button" onclick="location.href='register.jsp'"
				value="Registrati" />
		</form>
		<input type="button" onclick="location.href='changePwd.jsp'"
			value="Password dimenticata?" />
	</div>
	<c:choose>
		<c:when test="${result == 'ok'}">
			<p>
				<strong>PASSWORD REIMPOSTATA CON SUCCESSO</strong>
			</p>
		</c:when>

		<c:when test="${result == 'ko'}">
			<p>
				<strong>ERRORE DURANTE L'OPERAZIONE DI MODIFICA PER L'UTENTE</strong>
			</p>
		</c:when>
	</c:choose>
</body>
</html>