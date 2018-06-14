package main.model;

import java.util.List;

public class Privol implements Canale {
    @Override
    public void setCatalogoProdotti(List<Prodotto> prodotti) {
        System.out.println("STO STAMPANDO DAL CANALE PRIVOL!!!");
        prodotti.forEach(prodotto -> System.out.println(prodotto));
    }

    @Override
    public int getId() {
        return 0;
    }
}
