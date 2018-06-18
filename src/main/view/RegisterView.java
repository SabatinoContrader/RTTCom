package main.view;

import main.MainDispatcher;
import main.controller.Request;
import main.model.Utente;

import java.util.Scanner;

public class RegisterView implements View {

    private Integer id;
    private String username;
    private String password;
    private String nome;
    private String cognome;
    private Request request;

    public RegisterView() {
        this.request = new Request();
    }

    @Override
    public void showResults(Request request) {
        int v=0;
        if(request!=null) {
            v = (int)request.get("id");
            if (v>0) {
                System.out.println("Utente è stato aggiunto con successo");
                System.out.println();
                MainDispatcher.getInstance().callView("Login",null);
            } else {
                System.out.println("l'Utente non è stato aggiunto");
                System.out.println();
                MainDispatcher.getInstance().callView("Register",null);
            }
        }
    }

    @Override
    public void showOptions() {

        System.out.println(" -------- REGISTRAZIONE TRADER --------");
        System.out.println("Inserisci Username:");
        username = getInput();
        System.out.println("Inserisci Password:");
        password = getInput();
        System.out.println("Inserisci il Nome:");
        nome = getInput();
        System.out.println("Inserisci il Cognome:");
        cognome = getInput();
        Utente registrazione = new Utente(0, nome, cognome, username, password);
        request.put("registrazione", registrazione);
    }

    @Override
    public String getInput() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }

    @Override
    public void submit() {

        MainDispatcher.getInstance().callAction("Register", "doControl", request);
    }
}
