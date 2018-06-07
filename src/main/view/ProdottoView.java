package main.view;
import main.MainDispatcher;
import main.controller.Request;
import main.model.Acquisto;
import main.model.Prodotto;
import main.model.Profit;
import main.service.ProdottoService;

import java.util.List;
import java.util.Scanner;

public class ProdottoView implements View {

    private ProdottoService prodottoService;
    private String mode;

    public ProdottoView() {
        this.prodottoService = new ProdottoService();
        this.mode = "all";
    }

    @Override
    public void showResults(Request request) {
        this.mode = (String) request.get("mode");
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
                prodottoService.insertProdotto(new Prodotto(cod, category, product, model, manufacturer, price));
                break;

            case "insert_profit":
                System.out.println("Inserisci il codice del prodotto:");
                int codice = Integer.parseInt(this.getInput());
                System.out.println("Inserisci il nome dell'ecommerce che vuoi considerare:");
                String ecommerceName = this.getInput();
                System.out.println("Inserisci il margine di guadagno per il prodotto:");
                int margin = Integer.parseInt(this.getInput());
                if (!prodottoService.insertMargin(new Profit(codice, ecommerceName, margin))) {
                    System.out.println("Inserito margine con successo");
                } else
                    System.out.println("Margine non inserito");
                break;

            case "delete":
                Scanner scanner2 = new Scanner(System.in);
                System.out.println("Inserisci Id Prodotto");
                int codProd = Integer.parseInt(getInput());
                prodottoService.deleteProfit(new Profit(codProd));
                prodottoService.deleteProdotto(codProd);
                break;

            //case "search":
                //break;

            case "modify":
                Scanner scanner3 = new Scanner(System.in);
                System.out.println("Inserisci id del prodotto:");

                int cod1 = Integer.parseInt(getInput());
                if(prodottoService.getProdotto(cod1)!=null){

                System.out.println("Categoria:");
                String category1 = getInput();
                System.out.println("Prodotto:");
                String product1 = getInput();
                System.out.println("Modello:");
                String mode2 = getInput();
                System.out.println("Produttore:");
                String manufacturer1 = getInput();
                System.out.println("Prezzo:");
                double price1 = Double.parseDouble(getInput());
                prodottoService.modifyProdotto(new Prodotto(cod1, category1, product1, mode2, manufacturer1, price1), cod1);
               
                    System.out.println("Prodotto modificato con successo");
                } else
                    System.out.println("Modifica fallita");

                break;

            case "insert_request_buy":
                Scanner scanner4 = new Scanner(System.in);
                System.out.println("Inserisci i dati di richiesta d'acquisto:");
                System.out.println("Id prodotto:");
                int idproduct = Integer.parseInt(getInput());
                System.out.println("Quantità:");
                int quantity = Integer.parseInt(getInput());
                System.out.println("Prezzo per unità:");
                Double pricexelem = Double.parseDouble(getInput());
                System.out.println("Id trader:");
                String idtrader = getInput();
                prodottoService.insertRequestBuy(new Acquisto(idproduct, quantity, pricexelem, idtrader));
                break;
        }
    }

        @Override
        public String getInput () {
            Scanner scanner = new Scanner(System.in);
            return scanner.nextLine();
        }

        @Override
        public void submit() {
            MainDispatcher.getInstance().callAction("Home", "doControl", null);

        }


    }
