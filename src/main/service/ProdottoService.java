package main.service;

import main.dao.ProdottoDAO;
import main.model.Prodotto;

import java.util.List;

public class ProdottoService {

    private ProdottoDAO prodottoDAO;

    public ProdottoService() {
        this.prodottoDAO = new ProdottoDAO();
    }

    public List<Prodotto> getAllProdotti () {
        return this.prodottoDAO.getAllProdotti();
    }

    public boolean insertProdotto (Prodotto prodotto) {
        return this.prodottoDAO.insertProdotto(prodotto);
    }
}


