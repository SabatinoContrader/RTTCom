<html>
<head>
<title>Menu Principale Trader</title>
</head>
<body>
     <h1>Benvenuto <%= request.getSession().getAttribute("utente")%></h1>
     <h2>------- MENU TRADERS PLATFORM -------</h2>
     <h2>    </h2>

     <h3>1. Visualizza tutti i Prodotti</h3>
     <form action="/prodotto/ritornaProdotti" method="get">
     <input type="submit" value="listProdotti" name="richiesta">
     </form>
     
     <h3>2. Visualizza prodotti da fornitori</h3>
     <form action="/prodotto/ProdottiDaFornitori" method="get">
     <input type="submit" value="listProdotti" name="richiesta">
     </form>
     
     <h3>3. Copia prodotti da fornitori</h3>
     <form action="/prodotto/CopiaDaFornitori" method="get">
     <input type="submit" value="listProdotti" name="richiesta">
     </form>

     <h3>4. Ricerca un prodotto</h3>
     <form action="" method="post">
     <input type="submit" value="SearchProduct" name="richiesta">
     </form>

     <input type="button" onclick="location.href='/index.jsp'" value = "Logout"/>
</body>
</html>