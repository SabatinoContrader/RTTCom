package com.rttCom.rttCom.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import lombok.*;

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

	@OneToMany(mappedBy = "prodotto")
    private Set<ProdottoFornitore> listaAcquisto = new HashSet<ProdottoFornitore>();

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

    public void aggiungiAListaAcquisto(ProdottoFornitore prodottoFornitore){
        listaAcquisto.add(prodottoFornitore);
    }
    
    public Prodotto() {
    }

	public Prodotto(String ean, String category, String model, String manufacturer, String description,
			String longDescription, double sellPrice) {
		super();
		this.ean = ean;
		this.category = category;
		this.model = model;
		this.manufacturer = manufacturer;
		this.description = description;
		this.longDescription = longDescription;
		this.sellPrice = sellPrice;
	}

}
