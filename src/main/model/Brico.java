package main.model;

import java.util.LinkedList;
import java.util.List;

public class Brico implements Fornitore{

    @Override
    public List<Prodotto> getCatalogoProdotti() {
        List<Prodotto> prodotti = new LinkedList<Prodotto>();
        //int i = 0;
        prodotti.add(new Prodotto(12, 1, "categoria 1", "modello 1", "Brico")); // ho tolto i++
        prodotti.add(new Prodotto(15, 2, "categoria 2", "modello 2", "Brico"));
        prodotti.add(new Prodotto(17, 3, "categoria 3", "modello 3", "Brico"));
        prodotti.add(new Prodotto(14, 4, "categoria 4", "modello 4", "Brico"));
        prodotti.add(new Prodotto(78, 5, "categoria 5", "modello 5", "Brico"));
        prodotti.add(new Prodotto(41, 6, "categoria 6", "modello 6", "Brico"));
        prodotti.add(new Prodotto(43, 7, "categoria 7", "modello 7", "Brico"));
        return prodotti;
    }
}
