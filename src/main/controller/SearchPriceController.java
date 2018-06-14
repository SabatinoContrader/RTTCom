package main.controller;

import main.MainDispatcher;
import main.dao.VenditaDAO;
import main.model.Fornitore;
import main.model.Prodotto;
import main.model.ProdottoFornitore;

import java.util.ArrayList;
import java.util.List;

public class SearchPriceController implements Controller{

    private VenditaDAO venditaDAO;

    @Override
    public void doControl(Request request) {
        /*if (request != null) {
            List<Prodotto> listProdotti = (ArrayList<Prodotto>) request.get("listProdotti");
            List<ProdottoFornitore> prodottoFornitores = new ArrayList<ProdottoFornitore>();
            for (Prodotto prodotto : listProdotti) {
                int idprodotto = prodotto.getIdProduct();
                Fornitore fornitore = venditaDAO.getProdottofornitore(idprodotto);
                int idFornitore = fornitore.getIdFornitore();
                String dataInizio = fornitore.getDataInizio();
                String dataFine = fornitore.getData_fine();
                double prezzoAcquisto = fornitore.getPrezzoAcquisto();
                ProdottoFornitore prodottoFornitore = new ProdottoFornitore(idFornitore, dataInizio, dataFine, prezzoAcquisto);

                prodottoFornitores.add(prodottoFornitore);
            }
            request.put("listProdotti",prodottoFornitores);
            MainDispatcher.getInstance().callView("SearchPrice", request);
        }*/

    }

}
