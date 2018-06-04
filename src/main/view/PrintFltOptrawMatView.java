package main.view;

import main.MainDispatcher;
import main.controller.Request;
import main.model.Prodotto;

import java.util.ArrayList;
import java.util.List;

public class PrintFltOptrawMatView implements View  {

    private String category;
    private String subcategory;
    private String model;
    private String manufacturer;
    private double price;

    @Override
    public void showResults(Request request) {


        if (request != null){
            List<Prodotto> listProdotti=(ArrayList<Prodotto>)request.get("listProdotti");
            for(Prodotto prodotto:listProdotti){
                System.out.println(prodotto.toString());}

        } else {
            System.out.println(".> Nessun elemento trovato <.");
        }
        MainDispatcher.getInstance().callView("Home", null);

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
