package main.controller;

import main.MainDispatcher;
import main.dao.ProdottoDAO;
import main.model.Prodotto;
import main.dao.CanaleDAO;
import main.service.ProdottoService;

import java.util.LinkedList;
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
                List<Prodotto> listProdotti = new ProdottoService().getProdottiDisponibili();
                List<Prodotto> listProdottiFiltrata = new LinkedList<Prodotto>();
                listProdotti.forEach(prodotto -> {
                    if(prodotto.getCategory().equals(parolaChiaveTwo))
                        listProdottiFiltrata.add(prodotto);
                    });
                request.put("listProdotti", listProdottiFiltrata);
                MainDispatcher.getInstance().callView("Vendita", request);
            }


        }
    }



