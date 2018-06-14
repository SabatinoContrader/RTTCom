package main.model;

import java.util.LinkedList;
import java.util.List;

public class Inditex implements Fornitore{

    @Override
    public List<Prodotto> getCatalogoProdotti() {
        List<Prodotto> prodotti = new LinkedList<Prodotto>();
        //int i = 0;
        prodotti.add(new Prodotto(11, 1, "categoria 1", "modello 1", "Inditex"));
        prodotti.add(new Prodotto(22, 2, "categoria 2", "modello 2", "Inditex"));
        prodotti.add(new Prodotto(44, 3, "categoria 3", "modello 3", "Inditex"));
        prodotti.add(new Prodotto(56, 4, "categoria 4", "modello 4", "Inditex"));
        prodotti.add(new Prodotto(77, 5, "categoria 5", "modello 5", "Inditex"));
        prodotti.add(new Prodotto(89, 6, "categoria 6", "modello 6", "Inditex"));
        return prodotti;
    }
}
