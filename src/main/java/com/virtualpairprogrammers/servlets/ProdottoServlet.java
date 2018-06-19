package com.virtualpairprogrammers.servlets;

import com.virtualpairprogrammers.model.Prodotto;
import com.virtualpairprogrammers.service.ProdottoService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ProdottoServlet extends HttpServlet {

    private ProdottoService prodottoService;

    public void service (HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException {
        String scelta = request.getParameter("richiesta");
        HttpSession session = request.getSession(true);
        prodottoService =  new ProdottoService();
        switch (scelta) {
            case "ModificaProdotto":
                if(session.getAttribute("utente") == null)
                    response.sendRedirect("login.jsp");
                int prodottoModifica = Integer.parseInt(request.getParameter("id"));
                Prodotto prodotto = prodottoService.get(prodottoModifica);
                request.setAttribute("prodotto",prodotto);
                getServletContext().getRequestDispatcher("/insertProdotto.jsp").forward(request, response);
                break;
            case "ViewListProduct":
                List<Prodotto> allProdotti = this.prodottoService.getAllProdotti();
                request.setAttribute("all_product_fornitore", allProdotti);
                getServletContext().getRequestDispatcher("/listProdotti.jsp").forward(request, response);
                break;
            case "SearchCategory":
                String categoria = request.getParameter("category");
                List<Prodotto> allProdottiSearch = this.prodottoService.getAllProdotti();
                final List<Prodotto> searchProdotti = new ArrayList<Prodotto>();
                for (Prodotto prodottoSearch : allProdottiSearch) {
                    if(prodottoSearch.getCategory().contains(categoria))
                        searchProdotti.add(prodottoSearch);
                }
                request.setAttribute("all_product_fornitore", searchProdotti);
                getServletContext().getRequestDispatcher("/listProdotti.jsp").forward(request, response);
                break;
            case "SellProducts":
                String[] prodottiSell = request.getParameterValues("products");
                for (String prodottoSell : prodottiSell) {
                    System.out.println("ProdottoSell: " + prodottoSell);
                }
                getServletContext().getRequestDispatcher("/listProdotti.jsp").forward(request, response);
            case "ViewListProductFornitore":
                request.setAttribute("all_product_fornitore", prodottoService.getProdottiDisponibili());
                getServletContext().getRequestDispatcher("/listProdotti.jsp").forward(request, response);
            case "UpdateProdotto":
                int id = -1;
                try{
                    id = Integer.parseInt(request.getParameter("id"));
                }catch(Exception e){}
                String ean = request.getParameter("ean");
                String category = request.getParameter("category");
                String model = request.getParameter("model");
                String manufacturer = request.getParameter("manufacturer");
                String descrizione = request.getParameter("descrizione");
                String descrizioneLunga = request.getParameter("descrizioneLunga");
                double prezzoVendita = Double.parseDouble(request.getParameter("prezzoVendita"));
                Prodotto newInsert = new Prodotto(id, ean, category, model, manufacturer, descrizione, descrizioneLunga, prezzoVendita);
                if(id == -1)
                    this.prodottoService.insert(newInsert);
                else
                    this.prodottoService.update(newInsert);
                request.setAttribute("all_product_fornitore", prodottoService.getAllProdotti());
                getServletContext().getRequestDispatcher("/listProdotti.jsp").forward(request, response);
                break;

        }

    }

}
