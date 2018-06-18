package main.controller;

import main.MainDispatcher;
import main.model.*;
import main.service.VenditaService;

import java.util.List;

public class VenditaController implements Controller{

    private VenditaService venditaService;

    public VenditaController() {
        venditaService = new VenditaService();
    }

    @Override
    public void doControl(Request request) {
        int canale = (int) request.get("canale");
        double margine = (double) request.get("margine");
        List<Prodotto> listProdotti = (List<Prodotto>) request.get("prodotti");

        List<Prodotto> prodottiInVendita = venditaService.getCatalogoVendita(canale,margine,listProdotti);

        request.put("vendita",prodottiInVendita);

        MainDispatcher.getInstance().callView("Home", request);
    }

}
