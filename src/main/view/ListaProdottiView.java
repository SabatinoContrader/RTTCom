package main.view;

import main.MainDispatcher;
import main.controller.Request;
import main.model.Prodotto;
import main.service.ProdottoService;

import java.util.List;
import java.util.Scanner;

public class ListaProdottiView implements View{
    private int choice;
    private ProdottoService prodottoService;
    private String mode;
    private List<Prodotto> prodotti;
    private Request request;

    public ListaProdottiView() {
        this.request = new Request();
        this.prodottoService = new ProdottoService();
        this.mode = "all";
    }

    @Override
    public void showResults(Request request) {
        this.prodotti=(List<Prodotto>) request.get("prodotti");
        if(request != null && request.get("mode") != null)
            this.mode = request.get("mode").toString();

        if(mode.equalsIgnoreCase("filtered"))
            System.out.println("----- Prodotti filtrati -----");
        else
            System.out.println("----- Prodotti disponibili -----");

        System.out.println();
        this.prodotti.forEach(prodotto -> System.out.println(prodotto));
    }

    @Override
    public void showOptions() {
        System.out.println("------- PRODUCTS OPTIONS -------");
        System.out.println();
        System.out.println("1) Inserisci nuovo prodotto ");
        System.out.println("2) Modifica prodotto ");
        System.out.println("3) Elimina prodotto ");

        if(mode.equalsIgnoreCase("filtered")){
            System.out.println("4) Rimuovi filtri ");
            System.out.println("5) Vendi i prodotti ");
        }

        System.out.println("0) Torna alla home");
        System.out.print(".:> ");

        this.choice = Integer.parseInt(getInput());

        switch(choice){
            case 1: {
                int id = 0;
                System.out.println("Inserisci EAN:");
                String ean = getInput();
                System.out.println("Inserisci categoria:");
                String category = getInput();
                System.out.println("Inserisci modello:");
                String model = getInput();
                System.out.println("Inserisci manufacturer:");
                String manufacturer = getInput();
                System.out.println("Inserisci descrizione:");
                String description = getInput();
                System.out.println("Inserisci descrizione lunga:");
                String LongDescription = getInput();
                System.out.println("Inserisci prezzo di vendita:");
                double sellPrice = Double.parseDouble(getInput());
                Prodotto insertProdotto = new Prodotto(id,ean,category,model,manufacturer,description,LongDescription,sellPrice);
                request.put("insertProdotto", insertProdotto);
            }
            break;
            case 2:
            {
                System.out.println("Inserisci id prodotto:");
                System.out.print(".:> ");
                int idProdotto = Integer.parseInt(getInput());
                request.put("idProdotto", idProdotto);
            }
            break;
            case 3:
            {
                System.out.println("Inserisci id prodotto:");
                System.out.print(".:> ");
                int idProdotto = Integer.parseInt(getInput());
                request.put("idProdotto", idProdotto);
            }
            break;
        }
    }

    @Override
    public String getInput () {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }

    @Override
    public void submit()
    {
        if (choice < 1 || choice > 5){
            request.put("message", "erroreScelta");
            request.put("action", "home");
            MainDispatcher.getInstance().callAction("Home", "doControl", request);
        }
        switch(choice){
            case 1:
            {
                request.put("action", "inserisciProdotto");
                MainDispatcher.getInstance().callAction("Prodotto", "doControl", request);
            }
            break;
            case 2:
            {
                request.put("action", "visualizzaModificaProdotto");
                MainDispatcher.getInstance().callAction("Prodotto", "doControl", request);
            }
            break;
            case 3:
            {
                request.put("action", "cancellaProdotto");
                MainDispatcher.getInstance().callAction("Prodotto", "doControl", request);
            }
            break;
            case 4:
            {
                request.put("action", "listaProdotti");
                MainDispatcher.getInstance().callAction("Prodotto", "doControl", request);
            }
            break;
            case 5:
            {
                request.put("action", "sellProducts");
                request.put("prodotti", this.prodotti);
                MainDispatcher.getInstance().callAction("Prodotto", "doControl", request);
            }
            break;
            case 0:
            {
                MainDispatcher.getInstance().callAction("Home", "doControl", null);
            }
            break;
        }
        request.put("message", "erroreNavigazione");
        MainDispatcher.getInstance().callAction("Home", "doControl", null);
    }
}
