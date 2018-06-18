package main.view;

import main.MainDispatcher;
import main.controller.Request;

import java.util.Scanner;

public class LoginView implements View{

    private String nomeUtente;
    private String password;

    @Override
    public void showResults(Request request) {

    }

    @Override
    public void showOptions() {
        System.out.println("----- LOGIN PLATFORM -----");
        System.out.println("Inserisci username:");
        nomeUtente = getInput();
        System.out.println("Inserisci password:");
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
        MainDispatcher.getInstance().callAction("Login", "doControl", request);
    }


}
