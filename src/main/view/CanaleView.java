package main.view;

import main.MainDispatcher;
import main.controller.Request;

import main.model.Canale;

import main.service.CanaleService;

import java.util.List;
import java.util.Scanner;


public class CanaleView implements View {

    private String parolaChiaveOne;
    private String parolaChiaveTwo;

    private CanaleService canaleService;
    private String mode;

    public CanaleView() {

    }


    public void showResults(Request request) {


    }

    public void showOptions() {

                System.out.println("----- SELEZIONA PRODOTTI DA MANDARE IN VENDITA ----");
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
        MainDispatcher.getInstance().callAction("Canale", "doControl", request);
    }


}

