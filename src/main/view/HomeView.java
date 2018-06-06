package main.view;

import main.MainDispatcher;
import main.controller.Request;
import sun.applet.Main;

import java.util.Scanner;

public class HomeView implements View {

    private int choice;

    public void showResults(Request request) {

    }

    public void showOptions() {
        System.out.println("Benvenuto in ContraderFramework");
        System.out.println("");
        System.out.println("");
        System.out.println("-------MENU-------");
        System.out.println("");
        System.out.println("1) Inserisci prodotto");
        System.out.println("2) Visualizza prodotti disponibili");
        System.out.println("3) Inserisci il margine di profitto per un prodotto");
        System.out.println("4) Elimina prodotto");
        System.out.println("5) Ricerca Ottimizzazione Materiale");
        System.out.println("6) Modifica Prodotto");
        System.out.println("7) Logout");
        this.choice = Integer.parseInt(getInput());
    }

    public void submit() {
        if (choice < 1 || choice > 7)
            MainDispatcher.getInstance().callAction("Home", "doControl", null);
        else if (choice == 7)
            MainDispatcher.getInstance().callAction("LoginTrader", "doControl", null);
        else if (choice == 6)
            MainDispatcher.getInstance().callAction("LoginTrader", "doControl", null);
        else if(choice == 5)
            MainDispatcher.getInstance().callView("FilterOptRawMat", null);
        else {
            Request request = new Request();
            request.put("choice", choice);
            MainDispatcher.getInstance().callAction("Prodotto", "doControl", request);
        }
    }

    public String getInput(){
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }


}
