<%@ page import="com.virtualpairprogrammers.domain.Prodotto" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
 <head>
     <% List<Prodotto> allProdotti = (List<Prodotto>) session.getAttribute("listProdotti");%>
 </head>
 <body>
 <table>
     <tr>
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
     </tr>
        <%for (Prodotto prodotti : allProdotti) { %>
     <tr>

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
             <%=  prodotti.getManufacturer() %>
         </td>

     </tr>
     <% }%>
 </table>
 <a href="home.jsp">Home</a>
 </body>
</html>