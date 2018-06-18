<%@ page import="com.virtualpairprogrammers.domain.Prodotto" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
 <head>
     <% List<Prodotto> all_product_fornitore = (List<Prodotto>) session.getAttribute("all_product_fornitore");%>
 </head>
 <body>

<form action="ProdottoServlet" method="post">
    <input type="text" name="category">
    <input type="submit" value="SearchCategory" name="richiesta">
</form>

<form action="ProdottoServlet" method="post">
 <table>
 <tr>
   <td>
      Categoria:
   </td>
   <td>
   </td>
   </td>
   </tr>
     <tr>
        <th></th>
         <th>
             ID_PRODUCT
         </th>

         <th>
             EAN
         </th>
         <th>
             CATEGORY
         </th>
         <th>
             MODEL
         </th>
         <th>
             MANUFACTURER
         </th>
         <th>
            PREZZOACQUISTO
         </th>
         <th>
             PREZZOVENDITA
         </th>
     </tr>
        <%for (Prodotto prodotti : all_product_fornitore) { %>
     <tr>
        <td>
            <input type="checkbox" name="products" value="<%= prodotti.getIdProduct()%>"/>
        </td>
         <td>
             <%= prodotti.getIdProduct()%>
         </td>

         <td>
             <%=  prodotti.getEan()%>
         </td>

         <td>
             <%=  prodotti.getCategory()%>
         </td>

         <td>
             <%=  prodotti.getModel()%>
         </td>

         <td>
             <%=  prodotti.getManufacturer()%>
         </td>
         <td>
             <%=  prodotti.getPrezzoAcquisto()%>
         </td>
         <td>
             <%=  prodotti.getPrezzoVendita()%>
         </td>
     </tr>
     <% }%>
 </table>
<input type="submit" value="SellProducts" name="richiesta">
</form>
 <a href="home.jsp">Home</a>
 </body>
</html>