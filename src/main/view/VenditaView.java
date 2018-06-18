package main.view;
import main.MainDispatcher;
import main.controller.Request;
import main.model.Prodotto;

import java.util.List;
import java.util.Scanner;

public class VenditaView implements View {

    private double margine;
    private int canale;
    private double prezzo;
    private String data_inizio;
    private String data_fine;
    private String mode;
    private List<Prodotto> listProdotti;

    public VenditaView() {

    }


    public void showResults(Request request) {
        listProdotti = (List<Prodotto>) request.get("prodotti");
    }

    public void showOptions() {

        System.out.println("Inserisci il margine di guadagno per i prodotti:");
        margine = Double.parseDouble(this.getInput());
        System.out.println("Inserisci Id canale:");
        canale = Integer.parseInt(this.getInput());
        System.out.println();
    }

    @Override
    public String getInput() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }

    @Override
    public void submit() {
        Request request = new Request();
        request.put("data_inizio", this.data_inizio);
        request.put("data_fine", this.data_fine);
        //request.put("prezzo", this.prezzo);
        request.put("canale", this.canale);
        request.put("margine", this.margine);
        request.put("prodotti", this.listProdotti);
        MainDispatcher.getInstance().callAction("Vendita", "doControl", request);
    }

}
