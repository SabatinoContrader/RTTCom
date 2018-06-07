package main.model;

import java.util.Objects;

public class Acquisto {

    private int idproduct;
    private int quantity;
    private double pricexelem;
    private String idtrader;

    public Acquisto (int idproduct, int quantity, double pricexelem, String idtrader){
        this.idproduct = idproduct;
        this.quantity = quantity;
        this.pricexelem = pricexelem;
        this.idtrader = idtrader;
    }

    public int getIdproduct(){
        return idproduct;
    }

    public void setIdproduct(int idproduct){
        this.idproduct = idproduct;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getPricexelem() {
        return pricexelem;
    }

    public void setPricexelem(double pricexelem) {
        this.pricexelem = pricexelem;
    }

    public String getIdTrader() {
        return idtrader;
    }

    public void setIdtrader(String idtrader) {
        this.idtrader = idtrader;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Acquisto acquisto = (Acquisto) o;
        return idproduct == acquisto.idproduct &&
                Double.compare(acquisto.pricexelem, pricexelem) == 0 &&
                Objects.equals(idproduct, acquisto.idproduct) &&
                Objects.equals(quantity, acquisto.quantity) &&
                Objects.equals(idtrader, acquisto.idtrader);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idproduct, quantity, pricexelem,idtrader);
    }

    @Override
    public String toString() {
        return "CodProdPlatform:"+ idproduct + "\nQuantity: " + quantity + "\nModel: " + "\nPrice: " + pricexelem + "\nIdTrader: " + idtrader + "\n";
    }

}
