<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<html>
<head>
<title>Lista Prodotti</title>
</head>

<body>
	<form action="ProdottoServlet" method="post">
		<input type="text" name="colonna"> <input type="text"
			name="campoRiga"> <input type="submit" value="SearchCategory"
			name="richiesta">
	</form>
	<form action="/prodotto/ritornaProdotti" method="get">
		<table>
			<tr>
				<td>Categoria:</td>
				<td></td>
			</tr>
			<tr>
				<th></th>
				<th></th>
				<th>ID</th>
				<th>EAN</th>
				<th>CATEGORY</th>
				<th>MODEL</th>
				<th>MANUFACTURER</th>
				<th>DESCRIZIONE</th>
				<th>DESCRIZIONE LUNGA</th>
				<th>PREZZO ACQUISTO</th>

			</tr>
			<c:forEach items="${listProdotti}" var="prodotto">
				<!-- codice spring per visualizzare gli annunci -->

				<tr>
					<td><input type="checkbox" name="products"
						value="${prodotti.Id}" /></td>
					<td></td>
					<td>${prodotto.id}</td>
					<td>${prodotto.ean}</td>
					<td>${prodotto.category}</td>
					<td>${prodotto.model}</td>
					<td>${prodotto.manufacturer}</td>
					<td>${prodotto.description}</td>
					<td>${prodotto.long_description}</td>
					<td>${prodotto.sell_price}</td>

					<td><a
						href="ProdottoServlet?richiesta=ModificaProdotto&id=${prodotti.Id}">Modifica</a>
					</td>
					<td><a
						href="ProdottoServlet?richiesta=EliminaProdotto&id=${prodotti.Id}">Elimina</a>
					</td>
				</tr>
			</c:forEach>
		</table>
		<input type="submit" value="SellProducts" name="richiesta"> <button href="home.jsp">Home</button><h4><a href="insertProdotto.jsp">Inserisci Prodotto</a></h4>
	</form>
</body>
</html>