package main.controller;

import main.MainDispatcher;
import main.dao.ProdottoDAO;
import main.model.Prodotto;
import main.dao.CanaleDAO;

import java.util.List;


public class CanaleController implements Controller {

    private CanaleDAO canaleDAO;

    public CanaleController() {

        canaleDAO = new CanaleDAO();
    }
        @Override
        public void doControl(Request request) {
            if (request != null) {
                String parolaChiaveOne = request.get("parolaChiaveOne").toString();
                String parolaChiaveTwo = request.get("parolaChiaveTwo").toString();
                List<Prodotto> listProdotti= canaleDAO.search1(parolaChiaveOne, parolaChiaveTwo);
                request.put("listProdotti", listProdotti);
                MainDispatcher.getInstance().callView("Canale2", request);
            }


        }
    }



