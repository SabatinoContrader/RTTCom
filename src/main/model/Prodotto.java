package main.model;

import java.util.Objects;

public class Prodotto {

    private int barCode;
    private String category;
    private String subcategory;
    private String model;
    private String manufacturer;
    private double price;

    public Prodotto (int barCode, String category, String subcategory, String model, String manufacturer, double price) {
        this.barCode = barCode;
        this.category = category;
        this.subcategory = subcategory;
        this.model = model;
        this.manufacturer = manufacturer;
        this.price = price;
    }

    public int getBarCode(){return barCode;}

    public void setBarCode(int barCode){this.barCode=barCode;}

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getSubcategory() {
        return subcategory;
    }

    public void setSubcategory(String subcategory) {
        this.subcategory = subcategory;
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

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Prodotto prodotto = (Prodotto) o;
        return barCode == prodotto.barCode &&
                Double.compare(prodotto.price, price) == 0 &&
                Objects.equals(category, prodotto.category) &&
                Objects.equals(subcategory, prodotto.subcategory) &&
                Objects.equals(model, prodotto.model) &&
                Objects.equals(manufacturer, prodotto.manufacturer);
    }

    @Override
    public int hashCode() {

        return Objects.hash(barCode, category, subcategory, model, manufacturer, price);
    }

    @Override
    public String toString() {
        return "BarCode:"+ barCode + "\nCategory: " + category + "\nProduct: " + subcategory + "\nModel: " + model + "\nManufacturer: " +manufacturer + "\nPrice: "+price+"\n";

    }
}
