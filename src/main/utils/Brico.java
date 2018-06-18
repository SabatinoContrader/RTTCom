package main.utils;

import main.controller.GestoreEccezioni;
import main.model.Fornitore;
import main.model.Prodotto;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Brico implements Fornitore {

    @Override
    public List<Prodotto> getCatalogoProdotti() {
        List<Prodotto> prodotti = new LinkedList<Prodotto>();
        prodotti.add(new Prodotto(1,"EAN PROVA 1","Categoria 1", "Modello 1", "Manufacturer 1", "Descrizione 1", "Descrizione lunga 1", 100));
        prodotti.add(new Prodotto(2,"EAN PROVA 2","Categoria 1", "Modello 1", "Manufacturer 1", "Descrizione 1", "Descrizione lunga 1", 50));
        prodotti.add(new Prodotto(3,"EAN PROVA 3","Categoria 1", "Modello 1", "Manufacturer 1", "Descrizione 1", "Descrizione lunga 1", 80));
        prodotti.add(new Prodotto(4,"EAN PROVA 4","Categoria 1", "Modello 1", "Manufacturer 1", "Descrizione 1", "Descrizione lunga 1", 30));
        prodotti.add(new Prodotto(5,"EAN PROVA 5","Categoria 1", "Modello 1", "Manufacturer 1", "Descrizione 1", "Descrizione lunga 1", 150));
        prodotti.add(new Prodotto(6,"EAN PROVA 6","Categoria 1", "Modello 1", "Manufacturer 1", "Descrizione 1", "Descrizione lunga 1", 200));
        return prodotti;
    }

    @Override
    public int getId() {
        return 3;
    }

}
