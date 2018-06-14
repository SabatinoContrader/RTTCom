package main.service;

import main.controller.GestoreEccezioni;
import main.dao.ProdottoFornitoreDAO;
import main.model.*;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class ProdottoFornitoreService {

    private ProdottoFornitoreDAO prodottoFornitoreDAO;

    public ProdottoFornitoreService(){
        this.prodottoFornitoreDAO = new ProdottoFornitoreDAO();
    }

    /*
    public List<Prodotto> getAllProdotti() {
        return this.prodottoFornitoreDAO.getAllProdotti();
    }*/

    //Seguire qui....
    public List<Prodotto> getCatalogoProdotti(){
        return this.prodottoFornitoreDAO.getCatalogoProdotti();
    }

    public List<Acquisto> getAllRequestBuy (){
        return this.prodottoFornitoreDAO.getAllRequestBuy();
    }
}
