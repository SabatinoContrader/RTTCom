<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ page import="java.util.*"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>

</head>
<body>
	<form action="/prodotto/insertProdotto" method="post">
		<h2>
			ID<input type="hidden" name="id" value="${prodotto.id}">
		</h2>
		<h2>
			EAN<input type="text" name="ean" value="${prodotto.ean}">
		</h2>
		<h2>
			Category<input type="text" name="category"
				value="${prodotto.category}">
		</h2>
		<h2>
			Model<input type="text" name="model" value="${prodotto.model}">
		</h2>
		<h2>
			Manufacturer<input type="text" name="manufacturer"
				value="${prodotto.manufacturer}">
		</h2>
		<h2>
			Descrizione<input type="text" name="description"
				value="${prodotto.description}">
		</h2>
		<h2>
			Descrizione lunga<input type="text" name="long_description"
				value="${prodotto.long_description}">
		</h2>
		<h2>
			Prezzo di Vendita<input type="text" name="sell_price"
				value="${prodotto.sell_price}">
		</h2>
		<input type="submit" value="UpdateProdotto" name="richiesta">
	</form>

</body>
</html>
