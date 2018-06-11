package main.view;
import main.MainDispatcher;
import main.controller.Request;
import main.dao.ProdottoDAO;
import main.model.*;
import main.service.ProdottoFornitoreService;
import main.service.ProdottoService;

import java.util.List;
import java.util.Scanner;

public class ProdottoView implements View {

    private ProdottoFornitoreService prodottoFornitoreService;
    private ProdottoService prodottoService;
    private String mode;

    public ProdottoView() {
        this.prodottoFornitoreService = new ProdottoFornitoreService();
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
                /*List<Prodotto> prodotti = prodottoService.getAllProdotti();
                System.out.println("----- Prodotti disponibili -----");
                System.out.println();
                prodotti.forEach(prodotto -> System.out.println(prodotto));*/

                List<Prodotto> prodottiFornitori = prodottoFornitoreService.getAllProdotti();
                System.out.println("----- PRODOTTI DISPONIBILI -----");
                System.out.println();
                prodottiFornitori.forEach(prodottoFornitore -> System.out.println(prodottoFornitore));
                break;
            case "insert":
                Scanner scanner = new Scanner(System.in);
                System.out.println("Inserisci i dati del nuovo prodotto:");
                System.out.println("Codice Prodotto:");
                int cod = Integer.parseInt(getInput());
                System.out.println("Categoria:");
                int ean = Integer.parseInt(getInput());
                System.out.println("Prodotto:");
                String category = getInput();
                System.out.println("Modello:");
                String model = getInput();
                System.out.println("Produttore:");
                String manufacturer = getInput();
                System.out.println("Prezzo:");
                double price = Double.parseDouble(getInput());
                prodottoService.insertProdotto(new Prodotto(cod, ean, category, model, manufacturer));
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

                System.out.println("EAN:");
                int ean1 = Integer.parseInt(getInput());
                System.out.println("Categoria:");
                String category1 = getInput();
                System.out.println("Modello:");
                String mode2 = getInput();
                System.out.println("Produttore:");
                String manufacturer1 = getInput();
                prodottoService.modifyProdotto(new Prodotto(cod1, ean1, category1, mode2, manufacturer1), cod1);
               
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

            case "all_product_fornitore":
                List<ProdottoFornitore> prodottiFornitore = prodottoService.prodottoFornitore();
                System.out.println("----- PRODOTTI DISPONIBILI DEI FORNITORI-----");
                System.out.println();
                prodottiFornitore.forEach(fornitore ->System.out.println(fornitore));
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
