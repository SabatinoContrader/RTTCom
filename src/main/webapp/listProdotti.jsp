<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<html>
<head>
<title>Lista Prodotti</title>
</head>

<body>
	<form action="/prodotto/SearchProdotto" method="get">
		<div>
			Seleziona ricerca <select name="colonna">
				<option disabled selected value>-- Select an Option --</option>
				<option value="id">ID</option>
				<option value="ean">EAN</option>
				<option value="category">Category</option>
				<option value="model">Model</option>
				<option value="manufacturer">Manufacturer</option>
				<option value="price">Price</option>
			</select>
		</div>

		<div>
			Inserisci valore <input type="text" name="campo">
		</div>

		<div>
			<input type="submit" value="listProdottiFiltrati" name="richiesta">
		</div>
	</form>

	<form action="/prodotto/SearchPriceForInterval" method="get">

		Scegli Intervallo <select name="priceInterval">
			<optgroup label="Price">
				<option value="1-200">Fascia 1-200</option>
				<option value="201-300">Fascia 201-300</option>
				<option value="301-400">Fascia 301-400</option>
				<option value="401-500">Fascia 401-500</option>
				<option value="501-600">Fascia 501-600</option>
				<option value="601-700">Fascia 601-700</option>
			</optgroup>
		</select> <input type="submit" value="Cerca Prodotto" name="richiesta">
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
				<th>PREZZO VENDITA</th>

			</tr>


			<c:forEach items="${listProdotti}" var="prodotto">

				<tr>
					<td><input type="checkbox" name="products"
						value="${prodotti.id}" /></td>
					<td></td>
					<td>${prodotto.id}</td>
					<td>${prodotto.ean}</td>
					<td>${prodotto.category}</td>
					<td>${prodotto.model}</td>
					<td>${prodotto.manufacturer}</td>
					<td>${prodotto.description}</td>
					<td>${prodotto.longDescription}</td>
					<td>${prodotto.sellPrice}</td>

					<td><a href="/prodotto/ModificaProdotto?id=${prodotto.id}">Modifica</a>
					</td>
					<td><a href="/prodotto/EliminaProdotto?id=${prodotto.id}">Elimina</a>
					</td>
				</tr>
			</c:forEach>
		</table>
		<input type="submit" value="SellProducts" name="richiesta"> <input
			type="button" onclick="location.href='/insertProdotto.jsp'"
			value="InsertProduct" /> <input type="button"
			onclick="location.href='/home.jsp'" value="Back to home" />
	</form>

	<c:choose>
		<c:when test="${result == 'ok'}">
			<p>
				<strong>PRODOTTO INSERITO CON SUCCESSO</strong>
			</p>
		</c:when>

		<c:when test="${result == 'ko'}">
			<p>
				<strong>ERRORE DURANTE L'INSERIMENTO DEI DATI</strong>
			</p>
		</c:when>
	</c:choose>
</body>
</html>