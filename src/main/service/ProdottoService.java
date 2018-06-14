package main.service;

import main.dao.ProdottoDAO;
import main.model.*;

import java.util.LinkedList;
import java.util.List;

public class ProdottoService {

    private ProdottoDAO prodottoDAO;

    public ProdottoService() {
        this.prodottoDAO = new ProdottoDAO();
    }

    public List<Prodotto> getProdottiDisponibili(){
        List<Prodotto> prodotti = new LinkedList<Prodotto>();
        List<Fornitore> fornitori = FornitoreFactory.getInstance().getFornitori();
        for(int i=0;i<fornitori.size();i++){
            List<Prodotto> catalogoFornitore = fornitori.get(i).getCatalogoProdotti();
            for(int j = 0; j < catalogoFornitore.size(); j++){
                Prodotto prodottoDalFornitore = catalogoFornitore.get(j);
                ProdottoFornitore prodottoFornitore = new ProdottoFornitore(fornitori.get(i).getId(), "01/01/2018", null, prodottoDalFornitore.getPrezzoVendita());
                int indiceProdotto = cercaEanProdotto(prodottoDalFornitore, prodotti);
                if(indiceProdotto >= 0){
                    prodotti.get(indiceProdotto).aggiungiAListaAcquisto(prodottoFornitore);
                }else{
                    prodottoDalFornitore.aggiungiAListaAcquisto(prodottoFornitore);
                    prodotti.add(prodottoDalFornitore);
                }
            }
        }
        return prodotti;
    }

    private int cercaEanProdotto(Prodotto prodotto, List<Prodotto> catalogo){
        for(int i = 0; i < catalogo.size(); i++){
            if(catalogo.get(i).getEan() == prodotto.getEan())
                return i;
        }
        return -1;
    }

    public List<Prodotto> searchGetPrezzo (String parameterOne, String parameterTwo) {
        return this.prodottoDAO.searchGetPrezzo(parameterOne, parameterTwo);
    }

    public List<ProdottoFornitore> prodottoFornitore(){
        return this.prodottoDAO.prodottoFornitore();
    }

    public boolean insertRequestBuy(Acquisto acquisto){
        return this.prodottoDAO.insertRequestBuy(acquisto);
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

    public boolean deleteProfit(Profit p){
        return this.prodottoDAO.deleteProfit(p);
    }

    public boolean modifyProdotto (Prodotto pro, int id) {
        return this.prodottoDAO.modifyProdotto(pro,id);
    }

}