package main.model;


import java.util.Objects;

public class Fornitore {

    private int id_product;
    private int id_fornitore;
    private String data_inizio;
    private String data_fine;
    private double prezzo_acquisto;

    public Fornitore (int id_product, int id_fornitore, String data_inizio, String data_fine, double prezzo_acquisto) {
        this.id_product = id_product;
        this.id_fornitore = id_fornitore;
        this.data_inizio = data_inizio;
        this.data_fine = data_fine;
        this.prezzo_acquisto = prezzo_acquisto;
    }

    public int getIdProduct(){
        return id_product;
    }

    public void setIdProduct(int id_product){
        this.id_product = id_product;
    }

    public int getIdFornitore(){
        return id_fornitore;
    }

    public void setIdFornitore(int id_fornitore) {
        this.id_fornitore = id_fornitore;
    }
    public String getDataInizio() {
        return data_inizio;
    }

    public void setDataInizio(String data_inizio) {
        this.data_inizio = data_inizio;
    }

    public String getData_fine() {
        return data_fine;
    }

    public void setData_fine(String data_fine) {
        this.data_fine = data_fine;
    }

    public double getPrezzoAcquisto() {
        return prezzo_acquisto;
    }

    public void setPrezzoAcquisto(double prezzo_acquisto) {
        this.prezzo_acquisto = prezzo_acquisto;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Fornitore fornitore = (Fornitore) o;
        return id_product == fornitore.id_product &&
                Objects.equals(id_fornitore, fornitore.id_product) &&
                Objects.equals(data_inizio, fornitore.data_inizio) &&
                Objects.equals(data_fine, fornitore.data_fine) &&
                Double.compare(prezzo_acquisto, fornitore.prezzo_acquisto) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id_product, id_fornitore, data_inizio, data_fine, prezzo_acquisto);
    }

    @Override
    public String toString() {
        return "IdProduct:"+ id_product + "\nIdFornitore: " + id_fornitore +"\nDataInizio: " + data_inizio + "\nDataFine: " + data_fine + "\nBuysPrice: " + prezzo_acquisto + "\n";
    }

}
