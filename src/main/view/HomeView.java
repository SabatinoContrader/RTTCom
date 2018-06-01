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
        System.out.println("5) Logout");
        this.choice = Integer.parseInt(getInput());
    }

    public void submit() {
        if (choice < 1 || choice > 5)
            MainDispatcher.getInstance().callAction("Home", "doControl", null);
        else if (choice == 5)
            MainDispatcher.getInstance().callAction("Login", "doControl", null);
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
