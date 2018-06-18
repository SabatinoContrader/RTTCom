package main.view;

import main.MainDispatcher;
import main.controller.Request;
import sun.applet.Main;

import java.util.Scanner;

public class HomeView implements View {

    private int choice;

    public void showResults(Request request) {
        if(request != null && request.get("message") != null) {
            String message = request.get("message").toString();
            if (message.equals("erroreScelta"))
                System.out.println("Attenzione inserire una scelta valida!!!");
            if (message.equals("erroreNavigazione"))
                System.out.println("Attenzione si e' verificato un errore di navigazione!!!");
            if (message.equals("prodottiAggiornatiDaFornitori"))
                System.out.println("Ho aggiornato i prodotti dai fornitori!!!");
        }
    }

    public void showOptions() {
        System.out.println("Benvenuto in ContraderFramework");
        System.out.println();
        System.out.println();
        System.out.println("------- MENU TRADER'S PLATFORM -------");
        System.out.println();
        System.out.println("1) Visualizza prodotti ");
        System.out.println("2) Ricerca prodotti");
        System.out.println("3) Visualizza richieste d'acquisto");
        System.out.println("4) Aggiorna Prodotti Da Fornitori");
        System.out.println("5) Logout");
        System.out.print(".:> ");

        this.choice = Integer.parseInt(getInput());
    }

    public void submit() {
        Request request = new Request();
        if (choice < 1 || choice > 5){
            request.put("message", "erroreScelta");
            request.put("action", "home");
            MainDispatcher.getInstance().callAction("Home", "doControl", request);
        }
        else if (choice == 1) {
            request.put("action", "listaProdotti");
            MainDispatcher.getInstance().callAction("Prodotto", "doControl", request);
        }
        else if(choice == 2) {
            request.put("action", "cercaProdotti");
            MainDispatcher.getInstance().callAction("Prodotto", "doControl", request);
        }
        else if(choice == 3)
            MainDispatcher.getInstance().callView("Canale", null);
        else if(choice == 4) {
            request.put("action", "updateFromSuppliers");
            MainDispatcher.getInstance().callAction("Prodotto", "doControl", request);
        }
        else if(choice == 5)
            MainDispatcher.getInstance().callView("IndexHome", null);
        else {
            request.put("choice", choice);
            MainDispatcher.getInstance().callAction("Prodotto", "doControl", request);
        }
    }

    public String getInput(){
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }

}
