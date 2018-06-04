package main.view;

import main.MainDispatcher;
import main.controller.Request;

import java.util.Scanner;

public class LoginTraderView implements View{

    private String nomeUtente;
    private String password;

    @Override
    public void showResults(Request request) {

    }

    @Override
    public void showOptions() {

        System.out.println("-----LOGIN----");
        System.out.println("Nome TRADER utente:");
        nomeUtente = getInput();
        System.out.println("Password TRADER:");
        password = getInput();

    }

    @Override
    public String getInput() {

        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();

    }

    @Override
    public void submit() {

        Request request = new Request();
        request.put("nomeUtente", nomeUtente);
        request.put("password", password);
        MainDispatcher.getInstance().callAction("Home", "doControl", request);

    }


}
