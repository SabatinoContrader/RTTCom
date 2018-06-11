package main.view;

import main.MainDispatcher;
import main.controller.Request;
import main.model.Acquisto;
import main.model.Prodotto;
import main.model.ProdottoFornitore;
import main.service.ProdottoFornitoreService;
import main.service.ProdottoService;

import java.util.List;
import java.util.Scanner;

public class FornitoreView implements View {

    private ProdottoFornitoreService prodottoFornitoreService;
    private String mode;

    public FornitoreView() {
        this.prodottoFornitoreService = new ProdottoFornitoreService();
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
                List<Prodotto> prodottiFornitori = prodottoFornitoreService.getAllProdotti();
                System.out.println("----- PRODOTTI DISPONIBILI -----");
                System.out.println();
                prodottiFornitori.forEach(prodottoFornitore -> System.out.println(prodottoFornitore));
                break;
            case "all_request_buy":
                List<Acquisto> listrequest = prodottoFornitoreService.getAllRequestBuy();
                System.out.println("----- Lista richiesta d'acquisto -----");
                System.out.println();
                listrequest.forEach(Acquisto -> System.out.println(Acquisto));
                break;
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
