package main.view;

import main.MainDispatcher;
import main.controller.Request;

import java.util.Scanner;

public class HomeFornitoreView implements View {

    private int choice;

    @Override
    public void showResults(Request request) {

    }

    @Override
    public void showOptions() {

        System.out.println("Benvenuto in ContraderFramework");
        System.out.println();
        System.out.println();
        System.out.println("-------MENU FORNITORE-------");
        System.out.println();
        System.out.println("1) Visualizza prodotti disponibili");
        System.out.println("2) Visualizza richieste d'acquisto");
        System.out.println("3) Logout");
        this.choice = Integer.parseInt(getInput());

    }

    @Override
    public String getInput() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }

    @Override
    public void submit() {
        if (choice < 1 || choice > 3){
            MainDispatcher.getInstance().callView("HomeFornitore",null);
        }
        else if(choice == 3){
            MainDispatcher.getInstance().callView("IndexHome",null);
        }
        else{
        Request request = new Request();
        request.put("choice", choice);
        MainDispatcher.getInstance().callAction("Fornitore", "doControl", request);
        }

    }
}
