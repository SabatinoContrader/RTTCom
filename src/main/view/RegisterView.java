package main.view;

import main.MainDispatcher;
import main.controller.Request;

import java.util.Scanner;

public class RegisterView implements View {

    private String username;
    private String password;
    private String nome;
    private String cognome;

    @Override
    public void showResults(Request request) {


    }

    @Override
    public void showOptions() {
        System.out.println(" -------- REGISTRAZIONE TRADER --------");
        System.out.println("Inserisci Username:");
        username = getInput();
        System.out.println("Inserisci Paassword:");
        password = getInput();
        System.out.println("Inserisci il Nome:");
        nome = getInput();
        System.out.println("Inserisci il Cognome:");
        cognome = getInput();

    }

    @Override
    public String getInput() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }

    @Override
    public void submit() {
        Request request = new Request();
        request.put("nomeUtente", username);
        request.put("password", password);
        request.put("nome", nome);
        request.put("cognome", cognome);
        MainDispatcher.getInstance().callAction("Register", "doControl", request);
    }
}
