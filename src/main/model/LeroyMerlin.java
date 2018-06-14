package main.model;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class LeroyMerlin implements Fornitore {

    @Override
    public List<Prodotto> getCatalogoProdotti() {
        List<Prodotto> prodotti = new LinkedList<Prodotto>();
        //int i = 0;
        prodotti.add(new Prodotto(11, 1, "categoria 1", "modello 1", "Samsung", 3));
        prodotti.add(new Prodotto(23, 2, "categoria 1", "modello 1", "LeroyMerlyn", 100));
        prodotti.add(new Prodotto(25, 3, "categoria 1", "modello 1", "LeroyMerlyn", 10));
        prodotti.add(new Prodotto(44, 4, "categoria 4", "modello 1", "LeroyMerlyn", 10));
        prodotti.add(new Prodotto(67, 5, "categoria 5", "modello 1", "LeroyMerlyn", 10));
        prodotti.add(new Prodotto(58, 6, "categoria 6", "modello 1", "LeroyMerlyn", 25));
        return prodotti;
    }

    @Override
    public int getId() {
        return 1;
    }
}
