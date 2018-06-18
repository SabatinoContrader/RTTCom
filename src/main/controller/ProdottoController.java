package main.controller;

import main.MainDispatcher;
import main.model.Prodotto;
import main.service.ProdottoService;

public class ProdottoController implements Controller {

    private ProdottoService prodottoService = new ProdottoService();

    @Override
    public void doControl(Request request) {
        if(request == null)
            request = new Request();

        if(request.get("action") != null){
            if(request.get("action").toString().equalsIgnoreCase("listaProdotti")){
                request.put("prodotti", prodottoService.getAllProdotti());
                request.put("mode", "all");
                MainDispatcher.getInstance().callView("ListaProdotti", request);
            }
            if(request.get("action").toString().equalsIgnoreCase("cercaProdotti")){
                MainDispatcher.getInstance().callView("ProductsSearch", request);
            }
            if(request.get("action").toString().equalsIgnoreCase("applyFilter")){
                request.put("prodotti", prodottoService.search(request.get("parolaChiaveOne").toString(), request.get("parolaChiaveTwo").toString()));
                request.put("mode", "filtered");
                MainDispatcher.getInstance().callView("ListaProdotti", request);
            }
            if(request.get("action").toString().equalsIgnoreCase("sellProducts")){
                MainDispatcher.getInstance().callView("Vendita", request);
            }
            if(request.get("action").toString().equalsIgnoreCase("updateFromSuppliers")){
                prodottoService.aggiornaProdottiDaFornitori();
                request.put("message", "prodottiAggiornatiDaFornitori");
                MainDispatcher.getInstance().callView("Home", request);
            }
            if (request.get("action").toString().equalsIgnoreCase("inserisciProdotto")){
                Prodotto inseriscoProdotto = (Prodotto) request.get("insertProdotto");
                prodottoService.insert(inseriscoProdotto);
                MainDispatcher.getInstance().callView("Home", request);
                //-----------------------forse qui serve altro ----------------------
            }
            if(request.get("action").toString().equalsIgnoreCase("visualizzaModificaProdotto")){
                request.put("prodotto", prodottoService.get(Integer.parseInt(request.get("idProdotto").toString())));
                MainDispatcher.getInstance().callView("Product", request);
            }
            if(request.get("action").toString().equalsIgnoreCase("modificaProdotto")){
                Prodotto prodotto = (Prodotto) request.get("prodotto");
                prodottoService.update(prodotto);
                request.put("prodotti", prodottoService.getAllProdotti());
                request.put("mode", "all");
                MainDispatcher.getInstance().callView("ListaProdotti", request);
            }
            if(request.get("action").toString().equalsIgnoreCase("cancellaProdotto")){
                prodottoService.delete(Integer.parseInt(request.get("idProdotto").toString()));
                request.put("prodotti", prodottoService.getAllProdotti());
                request.put("mode", "all");
                MainDispatcher.getInstance().callView("ListaProdotti", request);
            }
        }
        request.put("message", "erroreNavigazione");
        MainDispatcher.getInstance().callView("Home", request);

    }
}
