<%@ page import="com.virtualpairprogrammers.model.Prodotto" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
 <head>
     <% List<Prodotto> allProduct = (List<Prodotto>) session.getAttribute("all_product");%>
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
            DESCRIZIONE
         </th>
         <th>
             DESCRIZIONE LUNGA
         </th>
         <th>
            PREZZO DI VENDITA
          </th>

     </tr>
        <%for (Prodotto prodotti : allProduct) { %>
     <tr>
         <td>
             <input type="checkbox" name="products" value="<%= prodotti.getId()%>"/>
         </td>

         <td>
             <%= prodotti.getId()%>
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
             <%=  prodotti.getDescrizione()%>
         </td>
         <td>
             <%=  prodotti.getDescrizioneLunga()%>
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
 <h2></h2>
 <h2></h2>
 <form action="" method="post">
 <h2>----- PRODUCT OPTIONS -----</h2>
 <h2>1 - Inserisci un nuovo Prodotto<input type="text" name=""></h2>
 <h2>2 -Modifica un prodotto<input type="submit" value="" name=""></h2>
 <h2>3 -Elimina un prodotto<input type="submit" value="" name=""></h2>
 <a href="home.jsp">Home</a>
 </form>
 </body>
</html>