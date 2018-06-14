package main.controller;

import main.MainDispatcher;
import main.model.Fornitore;
import main.model.FornitoreFactory;
import main.model.LeroyMerlin;
import main.model.Prodotto;
import main.service.ProdottoService;

import java.util.LinkedList;
import java.util.List;

public class ProdottoController implements Controller {

    private ProdottoService prodottoService = new ProdottoService();

    @Override
    public void doControl(Request request) {
        int choice = (int) request.get("choice");

        switch (choice) {
            case 1:
               request.put("mode", "insert");
               break;
            case 2:
                request.put("mode", "all");
                break;
            case 3:
                request.put("mode","insert_profit");
                break;
            case 4:
                request.put("mode", "delete");
                break;
            /*case 5:
                request.put("mode", "search");
                break; */
            case 6:
                request.put("mode", "modify");
                break;
            case 7:
                request.put("mode", "insert_request_buy");
                break;
            case 8:
                request.put("all_product_fornitore", prodottoService.getProdottiDisponibili());  // <- Lo faccio cosi perche faccio riferimento alla REQUEST definita nel package CONTROLLER
                request.put("mode","all_product_fornitore");
                break;
        }
        MainDispatcher.getInstance().callView("Prodotto", request);

    }
}
