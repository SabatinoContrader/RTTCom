package com.rttCom.model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

@Data

@Entity
public class Prodotto {

	@Id
	@Column
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(unique = true)
	private String ean;

	@Column
	private String category;

	@Column
	private String model;

	@Column
	private String manufacturer;

	@Column
	private String description;

	@Column(name = "long_description")
	private String longDescription;

	@Column(name = "sell_price")
	private double sellPrice;

	@OneToMany(fetch = FetchType.EAGER, mappedBy = "prodotto", cascade = CascadeType.ALL)
	@Fetch(value = FetchMode.SUBSELECT)
	private List<ProdottoFornitore> listaAcquisto = new ArrayList<ProdottoFornitore>();
	
	@OneToMany(fetch = FetchType.EAGER, mappedBy = "prodotto", cascade = CascadeType.ALL)
	@Fetch(value = FetchMode.SUBSELECT)
	private List<ProdottoCanale> listaVendita = new ArrayList<ProdottoCanale>();

	@OneToMany(fetch = FetchType.EAGER, mappedBy = "prodotto", cascade = CascadeType.ALL)
	@Fetch(value = FetchMode.SUBSELECT)
	private List<ProdottoOrdineVendita> listaOrdiniVendita = new ArrayList<ProdottoOrdineVendita>();

	@OneToMany(fetch = FetchType.EAGER, mappedBy = "prodotto", cascade = CascadeType.ALL)
	@Fetch(value = FetchMode.SUBSELECT)
	private List<ProdottoOrdineAcquisto> listaOrdiniAcquisto = new ArrayList<ProdottoOrdineAcquisto>();
	
	public Prodotto(String ean, String category, String model, String manufacturer, String description, String longDescription, double sellPrice) {
		this.ean = ean;
		this.category = category;
		this.model = model;
		this.manufacturer = manufacturer;
		this.description = description;
		this.longDescription = longDescription;
		this.sellPrice = sellPrice;
	}
	

    public double getPrezzoAcquisto(){
        if(listaAcquisto.size() == 0)
            return -1;
        double prezzoAcquisto = listaAcquisto.get(0).getPrezzoAcquisto();
        for(int i = 1; i < listaAcquisto.size(); i++) {
            if (listaAcquisto.get(i).getPrezzoAcquisto() < prezzoAcquisto) {
                prezzoAcquisto = listaAcquisto.get(i).getPrezzoAcquisto();
            }
        }
        return prezzoAcquisto;
    }
    
    public Fornitore getFornitoreSelezionato(){
        if(listaAcquisto.size() == 0)
            return null;
        double prezzoAcquisto = listaAcquisto.get(0).getPrezzoAcquisto();
        Fornitore fornitoreSelezionato = listaAcquisto.get(0).getFornitore();
        for(int i = 1; i < listaAcquisto.size(); i++) {
            if (listaAcquisto.get(i).getPrezzoAcquisto() < prezzoAcquisto) {
                prezzoAcquisto = listaAcquisto.get(i).getPrezzoAcquisto();
                fornitoreSelezionato = listaAcquisto.get(0).getFornitore();
            }
        }
        return fornitoreSelezionato;
    }

	/*
	 * public void aggiungiAListaAcquisto(ProdottoFornitore prodottoFornitore){
	 * listaAcquisto.add(prodottoFornitore); }
	 * 
	 * public List<ProdottoFornitore> getListaAcquisto(){ return listaAcquisto; }
	 * 
	 * public void setListaAcquisto(List<ProdottoFornitore> listaAcquisto) {
	 * this.listaAcquisto = listaAcquisto; }
	 */

	public void rimuoviDaListaAcquisto(int idFornitore) {
		// Da implementare
	}

	public void aggiungiAListaAcquisto(ProdottoFornitore prodottoFornitore) {
		listaAcquisto.add(prodottoFornitore);
	}

}
