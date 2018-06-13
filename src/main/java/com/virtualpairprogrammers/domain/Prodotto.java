package com.virtualpairprogrammers.domain;

import java.util.Objects;

public class Prodotto {
    private int id_product;
    private int ean;
    private String category;
    private String model;
    private String manufacturer;

    public Prodotto (int id_product, int ean, String category, String model, String manufacturer) {
        this.id_product = id_product;
        this.ean = ean;
        this.category = category;
        this.model = model;
        this.manufacturer = manufacturer;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Prodotto prodotto = (Prodotto) o;
        return id_product == prodotto.id_product &&
                Objects.equals(ean, prodotto.ean) &&
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
        return "IdProduct:"+ id_product + "\nEAN: " + ean +"\nCategory: " + category + "\nModel: " + model + "\nManufacturer: " +manufacturer + "\n";
    }
}
