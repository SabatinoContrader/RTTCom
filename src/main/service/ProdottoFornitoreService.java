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

    public List<Prodotto> getAllProdotti() {
        /*List<Prodotto> prodotti = new LinkedList<Prodotto>();
        List<Fornitore> fornitori = FornitoreFactory.getInstance().getFornitori();
        fornitori.forEach(fornitore -> prodotti.addAll(fornitore.getProdotti()));
        return prodotti;*/
        return this.prodottoFornitoreDAO.getAllProdotti();
    }

    public List<Acquisto> getAllRequestBuy (){
        return this.prodottoFornitoreDAO.getAllRequestBuy();
    }
}
