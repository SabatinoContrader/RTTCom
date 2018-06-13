<html>
<head>
<title>Menu Principale Trader</title>
</head>
<body>
     <h1>Benvenuto in ContraderFramework</h1>
     <h2>------- MENU TRADERS PLATFORM -------</h2>
     <h2>    <h2>
     <h3>1. Inserisci prodotto</h3>
     <a href="insertProdotto.jsp">Inserisci Prodotto</a>

     <h3>3. Elimina un prodotto</h3>
     <a href="deleteProdotto.jsp">Elimina Prodotto</a>

     <h3>3. Visualizza il catalogo Prodotti</h3>
         <form action="ProdottoServlet" method="post">
              <input type="submit" value="ViewProduct" name="richiesta">
         </form>

     <h3>10.logout<h3>
     <form action="LogoutServlet" method="post">
         <input type="submit" value="Logout" name="Logout">

     </form>

</body>
</html>