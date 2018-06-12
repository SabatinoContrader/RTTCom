package main.view;

import main.MainDispatcher;
import main.controller.Request;
import main.model.Prodotto;

import java.util.ArrayList;
import java.util.List;

public class Canale2View implements View{



    private String category;
    private String subcategory;
    private String model;
    private String manufacturer;
    private double price;

    @Override
    public void showResults(Request request) {

        List<Prodotto> listProdotti = (ArrayList<Prodotto>) request.get("listProdotti");
        if  (!listProdotti.isEmpty()){ //se la lista dei prodotti è diversa dal vuoto
            for (Prodotto prodotto : listProdotti) {
                System.out.println(prodotto.toString());
            }
        }else {
            System.out.println(".> Nessun elemento trovato <.");
            System.out.println();
            MainDispatcher.getInstance().callView("Home", request);
        }

        MainDispatcher.getInstance().callView("Vendita", request);

    }

    @Override
    public void showOptions() {

    }

    @Override
    public String getInput() {
        return null;
    }

    @Override
    public void submit() {

    }


}
