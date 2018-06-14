package main.model;

import java.util.LinkedList;
import java.util.List;

public class LeroyMerlin implements Fornitore {

    @Override
    public List<Prodotto> getCatalogoProdotti() {
        List<Prodotto> prodotti = new LinkedList<Prodotto>();
        //int i = 0;
        prodotti.add(new Prodotto(11, 1, "categoria 1", "modello 1", "LeroyMerlyn"));
        prodotti.add(new Prodotto(23, 2, "categoria 2", "modello 1", "LeroyMerlyn"));
        prodotti.add(new Prodotto(25, 3, "categoria 3", "modello 1", "LeroyMerlyn"));
        prodotti.add(new Prodotto(44, 4, "categoria 4", "modello 1", "LeroyMerlyn"));
        prodotti.add(new Prodotto(67, 5, "categoria 5", "modello 1", "LeroyMerlyn"));
        prodotti.add(new Prodotto(58, 6, "categoria 6", "modello 1", "manufacturer 1"));
        return prodotti;
    }
}
