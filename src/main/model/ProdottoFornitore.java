package main.model;

import java.util.Objects;

public class ProdottoFornitore {

    private int idprodotto;
    private int idfornitore;
    private String datainiziale;
    private String datafinale;
    private Double prezzoacquisto;

    public ProdottoFornitore (int idprodotto, int idfornitore, String datainiziale, String datafinale, Double prezzoacquisto) {
        this.idprodotto = idprodotto;
        this.idfornitore = idfornitore;
        this.datainiziale = datainiziale;
        this.datafinale = datafinale;
        this.prezzoacquisto = prezzoacquisto;
    }

    public int getIdprodotto(){
        return idprodotto;
    }

    public void setIdprodotto(int idprodotto){
        this.idprodotto=idprodotto;
    }

    public int getIdfornitore() {
        return idfornitore;
    }

    public void setIdfornitore(int idfornitore) {
        this.idfornitore = idfornitore;
    }

    public String getDatainiziale() {
        return datainiziale;
    }

    public void setDatainiziale(String datainiziale) {
        this.datainiziale = datainiziale;
    }

    public String getDatafinale() {
        return datafinale;
    }

    public void setDatafinale(String datafinale) {
        this.datafinale = datafinale;
    }

    public Double getPrezzoacquisto() {
        return prezzoacquisto;
    }

    public void setPrezzoacquisto(Double prezzoacquisto) {
        this.prezzoacquisto = prezzoacquisto;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProdottoFornitore prodottoFornitore = (ProdottoFornitore) o;
        return idprodotto == prodottoFornitore.idprodotto &&
                Double.compare(prodottoFornitore.prezzoacquisto, prezzoacquisto) == 0 &&
                Objects.equals(idfornitore, prodottoFornitore.idfornitore) &&
                Objects.equals(datainiziale, prodottoFornitore.datainiziale) &&
                Objects.equals(datafinale, prodottoFornitore.datafinale);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idprodotto, idfornitore, datainiziale, datafinale, prezzoacquisto);
    }

    @Override
    public String toString() {
        return "Idprodotto:"+ idprodotto + "\nIdfornitore: " + idfornitore + "\nDatainiziale: " + datainiziale + "\nDatafinale: " + datafinale + "\nPrezzoacquisto: " +prezzoacquisto+ "\n";
    }
}
