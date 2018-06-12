package main.model;

import java.util.Objects;


    public class Canale {

        private int barCode;
        private int canale1;
        private String datain;
        private String  datafin;
        private int margine;
        private double price;

        public Canale (int barCode, int canale1, String datain, String datafin, int margine, double price) {
            this.barCode = barCode;
            this.canale1 = canale1;
            this.datain = datain;
            this.datafin = datafin;
            this.margine = margine;
            this.price = price;
        }

        public int getBarCode(){return barCode;}


        public void setBarCode(int barCode){this.barCode=barCode;}

        public int getCanale1() {
            return canale1;
        }

        public void setCanale1(int canale1) {
            this.canale1 = canale1;
        }

        public String getDatain() {
            return datain;
        }

        public void setDatain(String datain) {
            this.datain = datain;
        }


        public String getDatafin() {
            return datafin;
        }

        public void setDatafin(String datafin) {
            this.datafin = datafin;
        }

        public int getMargine() {
            return margine;
        }

        public void setMargine(int margine) {
            this.margine = margine;
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
            main.model.Canale canale = (main.model.Canale) o;
            return barCode == canale.barCode &&
                    canale1== canale.canale1 &&
                    margine==canale.margine &&
                    Double.compare(canale.price, price) == 0 &&
                    Objects.equals(datain, canale.datain) &&
                    Objects.equals(datafin, canale.datafin) ;
        }

        @Override
        public int hashCode() {
            return Objects.hash(barCode, canale1,datain , datafin, margine, price);
        }

        @Override
        public String toString() {
            return "BarCode:"+ barCode + "\nCanale: " + canale1 + "\nDatainizio: " + datain + "\nDatafine: " + datafin + "\nMargine: " +margine + "\nPrice: "+price+"\n";
        }



    }



