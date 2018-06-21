<html>
<head>
<title>Login Trader</title>
</head>
<body>
   <div>
     <form action = "/utente/logintraderControl" method= "post">
     <h3>username: <input type = "text" id = "user" name ="username" placeholder = "inserisci username"></h3>
     <h3>password: <input type = "text" id = "pass" name ="password" placeholder = "inserisci password"></h3>
     <button type = "submit" value = "Login" name = "pulsante">Login In</button>
     <input type="button" onclick="location.href='register.jsp'" value = "Registrati"/>
     </form>
   </div>
</body>
</html>