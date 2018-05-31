package main.model;

public class Prodotto {

    private String category;
    private String product;
    private String model;
    private String manufacturer;
    private double price;

    public Prodotto (String category, String product, String model, String manufacturer, double price) {
        this.category = category;
        this.product = product;
        this.model = model;
        this.manufacturer = manufacturer;
        this.price = price;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
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

        if (Double.compare(prodotto.price, price) != 0) return false;
        if (category != null ? !category.equals(prodotto.category) : prodotto.category != null) return false;
        if (product != null ? !product.equals(prodotto.product) : prodotto.product != null) return false;
        if (model != null ? !model.equals(prodotto.model) : prodotto.model != null) return false;
        return manufacturer != null ? manufacturer.equals(prodotto.manufacturer) : prodotto.manufacturer == null;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = category != null ? category.hashCode() : 0;
        result = 31 * result + (product != null ? product.hashCode() : 0);
        result = model != null ? model.hashCode() : 0;
        result = 31 * result + (manufacturer != null ? manufacturer.hashCode() : 0);
        temp = Double.doubleToLongBits(price);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }

    @Override
    public String toString() {
        return "Category: " + category + "\nProduct: " + product + "\nModel: " + model + "\nManufacturer: " +manufacturer + "\nPrice: "+price+"\n";

    }
}
