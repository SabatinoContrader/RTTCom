package main.model;

import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

public class Prodotto {

    private int id_product;
    private int ean; //STRINGA
    private String category;
    private String model;
    private String manufacturer;
    private List<ProdottoFornitore> listaAcquisto;
    private double prezzoVendita;

    public Prodotto (int id_product, int ean, String category, String model, String manufacturer, double prezzoVendita) {
        this.id_product = id_product;
        this.ean = ean;
        this.category = category;
        this.model = model;
        this.manufacturer = manufacturer;
        this.prezzoVendita = prezzoVendita;
        this.listaAcquisto = new LinkedList<ProdottoFornitore>();
    }

    public int getIdProduct(){
        return id_product;
    }

    public void setIdProduct(int id_product){
        this.id_product = id_product;
    }

    public int getEan(){
        return ean;
    }

    public void setEan(int ean) {
        this.ean = ean;
    }
    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public double getPrezzoVendita() {
        return prezzoVendita;
    }

    public void setPrezzoVendita(double prezzoVendita) {
        this.prezzoVendita = prezzoVendita;
    }

    public void aggiungiAListaAcquisto(ProdottoFornitore prodottoFornitore){
        listaAcquisto.add(prodottoFornitore);
    }

    public void rimuoviDaListaAcquisto(int idFornitore){
        // Da implementare
    }

    public double getPrezzoAcquisto(){
        if(listaAcquisto.size() == 0)
            return -1;
        double prezzoAcquisto = listaAcquisto.get(0).getPrezzoacquisto();
        for(int i = 1; i < listaAcquisto.size(); i++) {
            if (listaAcquisto.get(i).getPrezzoacquisto() < prezzoAcquisto) {
                prezzoAcquisto = listaAcquisto.get(i).getPrezzoacquisto();
            }
        }
        return prezzoAcquisto;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Prodotto prodotto = (Prodotto) o;
        return id_product == prodotto.id_product &&
                ean == prodotto.ean &&
                Objects.equals(category, prodotto.category) &&
                Objects.equals(model, prodotto.model) &&
                Objects.equals(manufacturer, prodotto.manufacturer);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id_product, ean, category, model, manufacturer);
    }

    @Override
    public String toString() {
        return "Prodotto{" +
                "id_product=" + id_product +
                ", ean=" + ean +
                ", category='" + category + '\'' +
                ", model='" + model + '\'' +
                ", manufacturer='" + manufacturer + '\'' +
                ", prezzoAcquisto='" + getPrezzoAcquisto() + '\'' +
                ", prezzoVendita='" + getPrezzoVendita() + '\'' +
                '}';
    }
}
