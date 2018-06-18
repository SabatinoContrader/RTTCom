package com.virtualpairprogrammers.servlets;

import com.virtualpairprogrammers.model.Prodotto;
import com.virtualpairprogrammers.service.ProdottoService;

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
            case "ViewListProduct":
                List<Prodotto> allProdotti = this.prodottoService.getAllProdotti();
                session.setAttribute("all_product", allProdotti);
                response.sendRedirect("listProdotti.jsp");
                break;

        }

    }

}
