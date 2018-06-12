package main.model;

import java.util.Objects;

public class Vendita {

    private int id_canale;
    private int id_product;
    private String category;
    private String subcategory;
    private String model;
    private String manufacturer;
    private double prezzo_vendita;
    private String data_inizio;
    private String data_fine;
    private int margin_profit;



    public Vendita(int idp,int idc, String category, String model, String manufacturer,String datain, String datafin, double prezzov){
        this.id_product=idp;
        this.id_canale = idc;
        this.category = category;
       // this.subcategory = subcategory;
        this.model = model;
        this.manufacturer = manufacturer;
        this.data_inizio = datain;
        this.data_fine=datafin;
        this.prezzo_vendita = prezzov;
    }

    public int getId_product() {
        return id_product;
    }

    public int getId_product1(int idprodotto) {
        return id_product=idprodotto;
    }

    public int getId_canale() {
        return id_canale;
    }


    public int getId_canale1(int canale) {
        return id_canale=canale;
    }

    public int getMargin_profit() {
        return margin_profit;
    }

    public int getMargin_profit1(int margine) {
        return margin_profit=margine;
    }

    public String getCategory() {
        return category;
    }

    public String getCategory1(String categoria) {
        return category=categoria;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getSubcategory() { return subcategory; }

    //public String getSubcategory1(String subcategoria) { return subcategory=subcategoria; }

    //public void setSubcategory(String subcategory) {
     //   this.subcategory = subcategory;
   // }

    public String getData_inizio() {
        return data_inizio;
    }

    public String getData_inizio1(String datain) {
        return data_inizio=datain;
    }

    public void setData_inizio(String dataini) {
        this.data_inizio = dataini;
    }

    public String getData_fine() {
        return data_fine;
    }

    public String getData_fine1(String datafin) {
        return data_fine=datafin;
    }

    public void setData_fine(String datafin) {
        this.data_fine = datafin;
    }

    public String getModel() {
        return model;
    }

    public String getMode2(String modello) {
        return model=modello;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public String getManufacturer1(String manifattura) {
        return manufacturer=manifattura;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }




    public double getPrice() {
        return prezzo_vendita;
    }


    public double getPricevendita(double prezzo_acquisto, int margine) {
        double interesse;
        interesse=((margine*prezzo_acquisto)/100);
        prezzo_vendita=prezzo_acquisto+interesse;

        return prezzo_vendita;
    }

    public void setPrice(double price) {
        this.prezzo_vendita = price;
    }

    public void setId_product(int id_product) {
        this.id_product = id_product;
    }

    public void setId_canale(int id_canale) {
        this.id_canale = id_canale;
    }

    public void setMargin_profit(int margin_profit) {
        this.margin_profit = margin_profit;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Vendita vendita = (Vendita) o;
        return id_product == vendita.id_product &&
                id_canale == vendita.id_canale &&
                Double.compare(vendita.prezzo_vendita, prezzo_vendita) == 0 &&
                Objects.equals(category, vendita.category) &&
                //Objects.equals(subcategory, vendita.subcategory) &&
                Objects.equals(model, vendita.model) &&
                Objects.equals(data_inizio, vendita.data_inizio) &&
                Objects.equals(data_fine, vendita.data_fine) &&
                Objects.equals(manufacturer, vendita.manufacturer);
    }



    @Override
    public int hashCode() {
        return Objects.hash(id_product,id_canale,category, model, manufacturer, data_inizio,data_fine, prezzo_vendita);
    }

    @Override
    public String toString() {
        return "id_product=" + id_product +"id_canale:" + id_canale +"\nCategory: " + category  + "\nModel: " + model + "\nData inizio: " +data_inizio +"\nData fine: " +data_fine+ "\nPrezzo Vendita: "+prezzo_vendita+"\n";
    }

    }







