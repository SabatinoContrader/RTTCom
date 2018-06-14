package main.controller;

import main.MainDispatcher;
import main.dao.ProdottoDAO;
import main.model.Prodotto;


import java.util.List;

public class FilterOptRawMatController implements Controller{

    private ProdottoDAO prodottoDAO;

    public FilterOptRawMatController() {
        prodottoDAO = new ProdottoDAO();
        }

        public void doControl(Request request) {
            if (request != null) {
                String parolaChiaveOne = request.get("parolaChiaveOne").toString();
                String parolaChiaveTwo = request.get("parolaChiaveTwo").toString();
                List<Prodotto> listProdotti = prodottoDAO.searchGetPrezzo(parolaChiaveOne, parolaChiaveTwo);
                request.put("listProdotti", listProdotti);
                MainDispatcher.getInstance().callView("PrintFltOptrawMat", request);
        }

    }

}
