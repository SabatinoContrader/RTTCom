package main.model;

import java.util.Objects;

public class Profit {

    private int id_product;
    private String ecommerce_name;
    private int margin_profit;

    public Profit(int id,String name,int marginProfit){
        this.id_product = id;
        this.ecommerce_name = name;
        this.margin_profit = marginProfit;
    }

    public int getId_product() {
        return id_product;
    }

    public String getEcommerce_name() {
        return ecommerce_name;
    }

    public int getMargin_profit() {
        return margin_profit;
    }

    public void setId_product(int id_product) {
        this.id_product = id_product;
    }

    public void setEcommerce_name(String ecommerce_name) {
        this.ecommerce_name = ecommerce_name;
    }

    public void setMargin_profit(int margin_profit) {
        this.margin_profit = margin_profit;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Profit profit = (Profit) o;
        return margin_profit == profit.margin_profit &&
                Objects.equals(ecommerce_name, profit.ecommerce_name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ecommerce_name, margin_profit);
    }

    @Override
    public String toString() {
        return "Profit{" +
                "id_product=" + id_product +
                ", ecommerce_name='" + ecommerce_name + '\'' +
                ", margin_profit=" + margin_profit +
                '}';
    }
}
