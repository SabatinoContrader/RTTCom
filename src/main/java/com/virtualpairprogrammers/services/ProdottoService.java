package com.virtualpairprogrammers.services;

import com.virtualpairprogrammers.dao.ProdottoDAO;
import com.virtualpairprogrammers.domain.Prodotto;

import java.util.List;

public class ProdottoService {

    private ProdottoDAO prodottoDAO;
    private static ProdottoService reference;

    public static ProdottoService getService(){
        if(reference == null)
            reference = new ProdottoService();
        return reference;
    }

    public ProdottoService () {
        this.prodottoDAO = new ProdottoDAO();
    }

    /*

    public List<Prodotto> search (String parameterOne, String parameterTwo) {
        return this.prodottoDAO.search(parameterOne, parameterTwo);
    }

    public List<ProdottoFornitore> prodottoFornitore(){
        return this.prodottoDAO.prodottoFornitore();
    }

    public boolean insertRequestBuy(Acquisto acquisto){
        return this.prodottoDAO.insertRequestBuy(acquisto);
    } */
    public List<Prodotto> getAllProdotti () {
        return this.prodottoDAO.getAllProdotti();
    }


    public boolean insertProdotto (Prodotto prodotto) {
        return this.prodottoDAO.insertProdotto(prodotto);
    }


    /*
    public boolean insertMargin(Profit profit) {
        return this.prodottoDAO.insertMargin(profit);
    }
    */

    public boolean deleteProdotto (int prodotto) {
        return this.prodottoDAO.deleteProdotto(prodotto);
    }

    /*
    public Prodotto getProdotto (int barCode) {
        return this.prodottoDAO.getProdotto(barCode);
    }

    public boolean deleteProfit(Profit p){
        return this.prodottoDAO.deleteProfit(p);
    }

    public boolean modifyProdotto (Prodotto pro, int id) {
        return this.prodottoDAO.modifyProdotto(pro,id);

    }*/
}
