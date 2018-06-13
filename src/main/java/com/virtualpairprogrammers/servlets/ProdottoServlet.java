package com.virtualpairprogrammers.servlets;

import com.virtualpairprogrammers.domain.Prodotto;
import com.virtualpairprogrammers.services.LoginTraderService;
import com.virtualpairprogrammers.services.ProdottoService;

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

    public void service (HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException{
        prodottoService = ProdottoService.getService();
        String scelta = request.getParameter("richiesta");
        HttpSession session = request.getSession(true);  //<---????
        switch (scelta) {
            case "InserisciProdotto":
                int id_product = Integer.parseInt(request.getParameter("id_product"));
                int ean = Integer.parseInt(request.getParameter("ean"));
                String category = request.getParameter("category");
                String model = request.getParameter("model");
                String manufacturer = request.getParameter("manufacturer");
                Prodotto newInsert = new Prodotto(id_product, ean, category, model, manufacturer);
                this.prodottoService.insertProdotto(newInsert);
                response.sendRedirect("home.jsp");
                break;
            case "ViewProduct":
                List<Prodotto> allProdotti = new ArrayList<Prodotto>();
                allProdotti = this.prodottoService.getAllProdotti();
                session.setAttribute("listProdotti", allProdotti);
                response.sendRedirect("listProdotti.jsp");
                break;
        }

    }

}
