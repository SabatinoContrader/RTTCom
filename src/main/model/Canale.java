package main.model;

import java.util.List;
import java.util.Objects;

public interface Canale {
    void setCatalogoProdotti(List<Prodotto> prodotti);
    int getId();
}
