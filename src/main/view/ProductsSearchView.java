package main.view;

import main.MainDispatcher;
import main.controller.Request;

import java.util.Scanner;

public class ProductsSearchView implements View{

    private String parolaChiaveOne;
    private String parolaChiaveTwo;

    private String mode;

    public ProductsSearchView() {
    }


    public void showResults(Request request) {
    }

    public void showOptions() {
        System.out.println("Inserisci Campo:");
        parolaChiaveOne = getInput();
        System.out.println("Inserisci parola chiave:");
        parolaChiaveTwo = getInput();
        System.out.println();
    }

    @Override
    public String getInput() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }

    @Override
    public void submit() {

        Request request = new Request();
        request.put("parolaChiaveOne", this.parolaChiaveOne);
        request.put("parolaChiaveTwo", this.parolaChiaveTwo);
        request.put("action", "applyFilter");
        MainDispatcher.getInstance().callAction("Prodotto", "doControl", request);
    }

}
