package main.view;

import main.MainDispatcher;
import main.controller.Request;
import java.util.Scanner;

public class RegisterView implements View {

    private String nomeUtente;
    private String passwordUtente;


    @Override
    public void showResults(Request request) {
        if(request!=null) {
            boolean v = (boolean) request.get("response");
            if (v) {
                System.out.println("Utente aggiunto con successo");
                MainDispatcher.getInstance().callView("LoginTrader",null);
            } else {
                System.out.println("Utente non aggiunto");
            }
        }
    }

    @Override
    public void showOptions() {
        System.out.println("Inserisci il nome utente:");
        this.nomeUtente = this.getInput();
        System.out.println("Inserisci la password:");
        this.passwordUtente = this.getInput();
    }

    @Override
    public String getInput() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }

    @Override
    public void submit() {
        Request request = new Request();
        request.put("nomeUtente",this.nomeUtente);
        request.put("passwordUtente",this.passwordUtente);
        MainDispatcher.getInstance().callAction("Register","doControl",request);
    }
}
