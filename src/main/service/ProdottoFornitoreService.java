package main.service;

import main.dao.ProdottoFornitoreDAO;
import main.model.Acquisto;
import main.model.ProdottoFornitore;

import java.util.List;

public class ProdottoFornitoreService {

    private ProdottoFornitoreDAO prodottoFornitoreDAO;

    public ProdottoFornitoreService(){
        this.prodottoFornitoreDAO = new ProdottoFornitoreDAO();
    }

    public List<ProdottoFornitore> getAllProdotti() {
        return this.prodottoFornitoreDAO.getAllProdotti();
    }

    public List<Acquisto> getAllRequestBuy (){
        return this.prodottoFornitoreDAO.getAllRequestBuy();
    }
}
