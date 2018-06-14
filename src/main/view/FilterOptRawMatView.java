package main.view;

import main.MainDispatcher;
import main.controller.Request;

import java.util.Scanner;

public class FilterOptRawMatView implements View{

    private String parolaChiaveOne;
    private String parolaChiaveTwo;

    public FilterOptRawMatView () {
    }

    @Override
    public void showResults(Request request) {
    }

    @Override
    public void showOptions() {
        System.out.println("----- RICERCA MATERIALE ----");
        System.out.println("Inserisci 1.a parola chiave:");
        parolaChiaveOne = getInput();
        System.out.println("Inserisci 2.a parola chiave:");
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
        request.put("parolaChiaveOne", this.parolaChiaveOne); // delete il this
        request.put("parolaChiaveTwo", this.parolaChiaveTwo); // delete il this
        MainDispatcher.getInstance().callAction("FilterOptRawMat", "doControl", request);
    }

}
