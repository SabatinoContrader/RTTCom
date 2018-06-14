package main.model;

import main.controller.GestoreEccezioni;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Brico implements Fornitore{

    @Override
    public List<Prodotto> getCatalogoProdotti() {
        List<Prodotto> prodotti = new LinkedList<Prodotto>();
        //int i = 0;
        prodotti.add(new Prodotto(12, 1, "categoria 1", "modello 1", "Brico", 10)); // ho tolto i++
        prodotti.add(new Prodotto(15, 2, "categoria 1", "modello 2", "Brico", 6));
        prodotti.add(new Prodotto(17, 3, "categoria 3", "modello 3", "Brico", 10));
        prodotti.add(new Prodotto(14, 4, "categoria 4", "modello 4", "Brico", 8));
        prodotti.add(new Prodotto(78, 5, "categoria 5", "modello 5", "Brico", 10));
        prodotti.add(new Prodotto(41, 6, "categoria 6", "modello 6", "Brico", 10));
        prodotti.add(new Prodotto(43, 7, "categoria 7", "modello 7", "Brico", 10));
        return prodotti;
    }

    @Override
    public int getId() {
        return 3;
    }

}
