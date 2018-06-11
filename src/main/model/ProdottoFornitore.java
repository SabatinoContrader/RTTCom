package main.model;

import java.util.Objects;

public class ProdottoFornitore {

    private int id_fornitore;
    private String data_inizio;
    private String data_fine;
    private Double prezzo_acquisto;

    public ProdottoFornitore (int id_fornitore, String data_inizio, String data_fine, Double prezzo_acquisto) {
        this.id_fornitore = id_fornitore;
        this.data_inizio = data_inizio;
        this.data_fine = data_fine;
        this.prezzo_acquisto = prezzo_acquisto;
    }

    public int getIdfornitore() {
        return id_fornitore;
    }

    public void setIdfornitore(int id_fornitore) {
        this.id_fornitore = id_fornitore;
    }

    public String getDatainiziale() {
        return data_inizio;
    }

    public void setDatainiziale(String data_inizio) {
        this.data_inizio = data_inizio;
    }

    public String getDatafinale() {
        return data_fine;
    }

    public void setDatafinale(String datafinale) {
        this.data_fine = data_fine;
    }

    public Double getPrezzoacquisto() {
        return prezzo_acquisto;
    }

    public void setPrezzoacquisto(Double price) {
        this.prezzo_acquisto = prezzo_acquisto;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProdottoFornitore prodottoFornitore = (ProdottoFornitore) o;
        return Double.compare(prodottoFornitore.prezzo_acquisto, prezzo_acquisto) == 0 &&
                Objects.equals(id_fornitore, prodottoFornitore.id_fornitore) &&
                Objects.equals(data_inizio, prodottoFornitore.data_inizio) &&
                Objects.equals(data_fine, prodottoFornitore.data_fine);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id_fornitore, data_inizio, data_fine, prezzo_acquisto);
    }

    @Override
    public String toString() {
        return "Idfornitore: " + id_fornitore + "\nDatainiziale: " + data_inizio + "\nDatafinale: " + data_fine + "\nPrezzoacquisto: " + prezzo_acquisto + "\n";
    }
}
