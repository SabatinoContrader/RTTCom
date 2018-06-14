package main.controller;

import main.MainDispatcher;
import main.dao.VenditaDAO;
import main.model.Fornitore;
import main.model.Prodotto;
import main.model.Vendita;

import java.util.ArrayList;
import java.util.List;

public class VenditaController implements Controller{

    private VenditaDAO venditaDAO;
    private VenditaDAO vendita1DAO;

    public VenditaController() {
    venditaDAO = new VenditaDAO();
    vendita1DAO=new VenditaDAO();
    }

    @Override
    public void doControl(Request request) {
        /*if (request != null) {
            List<Prodotto> listProdotti = (ArrayList<Prodotto>) request.get("listProdotti");
            for (Prodotto prodotto : listProdotti) {
                int canale = (int) request.get("canale");
                String data_inizio = (String) request.get("data_inizio");
                String data_fine = (String) request.get("data_fine");

                int margine = (int) request.get("margine");
                int idprodotto = prodotto.getIdProduct();
                Fornitore fo = vendita1DAO.getProdottofornitore(idprodotto);
                double prezzo_acquisto = fo.getPrezzoAcquisto();

                Vendita vendita = new Vendita(prodotto.getIdProduct(), canale, prodotto.getCategory(), prodotto.getModel(), prodotto.getManufacturer(), data_inizio, data_fine, prezzo_acquisto);


                venditaDAO.modificavendita(vendita, margine, prezzo_acquisto);

            }*/

            MainDispatcher.getInstance().callView("Home", request);
        }


    //}

}
