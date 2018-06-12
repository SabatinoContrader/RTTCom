package main.view;
import main.MainDispatcher;
import main.controller.Request;
import main.model.Prodotto;
import main.model.Vendita;
import main.service.CanaleService;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class VenditaView implements View {

    private int margine;
    private int canale;
    private double prezzo;
    private String data_inizio;
    private String data_fine;

    private CanaleService canaleService;
    private String mode;
    private List<Prodotto> listProdotti;
    private List<Vendita> listProdottivendita;

    public VenditaView() {

    }


    public void showResults(Request request) {
        listProdotti= (ArrayList<Prodotto>) request.get("listProdotti");


       // List<Vendita> listProdottivendita = (ArrayList<Vendita>) request.get("listProdottivendita");
        //if  (!listProdottivendita.isEmpty()){ //se la lista dei prodotti è diversa dal vuoto
          //  for (Vendita vendita : listProdottivendita) {
            //    System.out.println(vendita.toString());
           // }
        //}else {
          //  System.out.println(".> Nessun elemento trovato <.");
            //System.out.println();
            //MainDispatcher.getInstance().callView("Home", request);
        }


    public void showOptions() {

        System.out.println("Inserisci il margine di guadagno per i prodotti:");
        margine = Integer.parseInt(this.getInput());
        System.out.println("Inserisci Id canale:");
        canale = Integer.parseInt(this.getInput());
        System.out.println("Inserisci data di inizio vendita:");
        data_inizio=getInput();
        System.out.println("Inserisci data di fine vendita:");
        data_fine=getInput();

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
        request.put("listProdotti", this.listProdotti);
        request.put("listProdottivendita", this.listProdottivendita);
        MainDispatcher.getInstance().callAction("Vendita", "doControl", request);
    }






}
