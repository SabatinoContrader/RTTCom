package main.view;
import main.MainDispatcher;
import main.controller.Request;
import main.model.Prodotto;
import main.dao.ProdottoDAO;
import main.service.ProdottoService;

import java.util.List;
import java.util.Scanner;

public class ProdottoView implements View {

    private ProdottoService prodottoService;
    private String mode;

  public ProdottoView () {
      this.prodottoService = new ProdottoService();
      this.mode = "all";
  }

    @Override
    public void showResults(Request request) {
       this.mode  = (String) request.get("mode");
    }

    @Override
    public void showOptions() {
        switch (mode) {
            case "all":
                List<Prodotto> prodotti = prodottoService.getAllProdotti();
                System.out.println("----- Prodotti disponibili -----");
                System.out.println();
                prodotti.forEach(prodotto -> System.out.println(prodotto));
                break;
            case "insert":
                Scanner scanner = new Scanner(System.in);
                System.out.println("Inserisci i dati del nuovo prodotto:");
                System.out.println("Codice Prodotto:");
                int cod = Integer.parseInt(getInput());
                System.out.println("Categoria:");
                String category = getInput();
                System.out.println("Prodotto:");
                String product = getInput();
                System.out.println("Modello:");
                String model = getInput();
                System.out.println("Produttore:");
                String manufacturer = getInput();
                System.out.println("Prezzo:");
                double price = Double.parseDouble(getInput());
                prodottoService.insertProdotto(new Prodotto(cod,category, product, model, manufacturer, price));
            case "insert_profit":

        }
    }

    @Override
    public String getInput() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
  }

    @Override
    public void submit() {
        MainDispatcher.getInstance().callAction("Home", "doControl", null);
    }



}
