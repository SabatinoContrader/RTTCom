<html>
<head>
<title>Menu Principale Trader</title>
</head>
<body>
     <h1>Benvenuto in ContraderFramework</h1>
     <h2>------- MENU TRADERS PLATFORM -------</h2>
     <h2>    <h2>

     <h3>1. Visualizza il catalogo Prodotti</h3>
     <form action="ProdottoServlet" method="post">
     <input type="submit" value="ViewProduct" name="richiesta">
     </form>

     <h3>2. Inserisci prodotto</h3>
     <a href="insertProdotto.jsp">Inserisci Prodotto</a>

     <h3>3. Modifica prodotto</h3>
          <a href="">Modifica Prodotto</a>

     <h3>4. Elimina un prodotto</h3>
     <a href="deleteProdotto.jsp">Elimina Prodotto</a>

     <h3>5. Ricerca un prodotto</h3>
     <form action="" method="post">
     <input type="submit" value="SearchProduct" name="richiesta">
     </form>

     <h3>6. Visualizza lista prodotti</h3>
     <form action="ProdottoServlet" method="get">
     <input type="submit" value="ViewListProduct" name="richiesta">
     </form>

     <h3>7. Vendita i Prodotti</h3>
     <a href="SelectCampo.jsp">inserisci i campi di riferimento</a>

     <h3>8.logout<h3>
     <form action="LogoutServlet" method="post">
     <input type="submit" value="Logout" name="Logout">
     </form>

</body>
</html>