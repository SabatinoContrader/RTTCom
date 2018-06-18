package main.view;

import main.MainDispatcher;
import main.controller.Request;
import main.model.Prodotto;

import java.util.Scanner;

public class ProductView implements View {
    private Prodotto prodotto;

    public ProductView() {

    }

    public void showResults(Request request) {
        if(request != null && request.get("prodotto") != null) {
            this.prodotto = (Prodotto) request.get("prodotto");
        }
        System.out.println("--- Dati del prodotto: ---");
        System.out.println("Id: " + prodotto.getId());
        System.out.println("Modello: " + prodotto.getModel());
        System.out.println("Produttore: " + prodotto.getManufacturer());
    }

    public void showOptions() {
        System.out.println("--- Modifica prodotto: ---");
        System.out.print("Modello: " + prodotto.getModel());
        System.out.println(" - Nuovo valore: ");
        String dato = getInput();
        prodotto.setModel(dato);
        System.out.print("Produttore: " + prodotto.getManufacturer());
        System.out.println(" - Nuovo valore: ");
        dato = getInput();
        prodotto.setManufacturer(dato);
    }

    @Override
    public String getInput() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }

    @Override
    public void submit() {
        Request request = new Request();
        request.put("prodotto", prodotto);
        request.put("action", "modificaProdotto");
        MainDispatcher.getInstance().callAction("Prodotto", "doControl", request);
    }
}
