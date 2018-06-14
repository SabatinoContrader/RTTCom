package main.view;

import main.MainDispatcher;
import main.controller.Request;
import main.model.Prodotto;
import main.model.ProdottoFornitore;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SearchPriceView implements View {

    private List<ProdottoFornitore> listProdotto;

    @Override
    public void showResults(Request request) {
        List<ProdottoFornitore> listProdotti = (ArrayList<ProdottoFornitore>) request.get("listProdotti");
        if  (!listProdotti.isEmpty()){
            for (ProdottoFornitore prodotto : listProdotti) {
                System.out.println(prodotto.toString());

            }
        }else {
            System.out.println(".> Nessun elemento trovato <.");
            System.out.println();
        }
        System.out.println();
        System.out.println();
        MainDispatcher.getInstance().callView("Home", request);
    }

    @Override
    public void showOptions() {
    }

    @Override
    public String getInput() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }

    @Override
    public void submit() {

    }
}
