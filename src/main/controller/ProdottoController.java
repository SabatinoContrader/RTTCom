package main.controller;

import main.MainDispatcher;
import main.model.Fornitore;
import main.model.FornitoreFactory;
import main.model.Prodotto;

import java.util.LinkedList;
import java.util.List;

public class ProdottoController implements Controller {


    @Override
    public void doControl(Request request) {
        int choice = (int) request.get("choice");

        switch (choice) {
            case 1:
               request.put("mode", "insert");
               break;
            case 2:{
                    List<Prodotto> prodotti = new LinkedList<Prodotto>();
                    List<Fornitore> fornitori = FornitoreFactory.getInstance().getFornitori();
                    fornitori.forEach(fornitore -> prodotti.addAll(fornitore.getCatalogoProdotti()));
                }
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
                request.put("mode","all_product_fornitore");
                break;
        }
        MainDispatcher.getInstance().callView("Prodotto", request);

    }
}
