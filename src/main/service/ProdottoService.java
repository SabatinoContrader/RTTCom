package main.service;

import main.dao.ProdottoDAO;
import main.model.Prodotto;
import main.model.Profit;

import java.util.List;

public class ProdottoService {

    private ProdottoDAO prodottoDAO;

    public ProdottoService() {
        this.prodottoDAO = new ProdottoDAO();
    }

    public List<Prodotto> search (String parameterOne, String parameterTwo) {
        return this.prodottoDAO.search(parameterOne, parameterTwo);
    }

    public List<Prodotto> getAllProdotti () {
        return this.prodottoDAO.getAllProdotti();
    }

    public boolean insertProdotto (Prodotto prodotto) {
        return this.prodottoDAO.insertProdotto(prodotto);
    }


    public boolean insertMargin(Profit profit) {
        return this.prodottoDAO.insertMargin(profit);
    }

    public boolean deleteProdotto (int prodotto) {
        return this.prodottoDAO.deleteProdotto(prodotto);
    }

    public Prodotto getProdotto (int barCode) {
        return this.prodottoDAO.getProdotto(barCode);
    }

    public boolean deleteProfit(Profit p){ return this.prodottoDAO.deleteProfit(p);}

    public boolean modifyProdotto (Prodotto pro, int id) {
        return this.prodottoDAO.modifyProdotto(pro,id);

    }

}