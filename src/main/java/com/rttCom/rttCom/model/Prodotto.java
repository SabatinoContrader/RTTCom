package com.rttCom.rttCom.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "prodotto")
public class Prodotto {

	@Id
	@Column
	@GeneratedValue(strategy = GenerationType.AUTO)
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

	@Column
	private String long_description;

	// private List<ProdottoFornitore> listaAcquisto;

	@Column
	private int sell_price;

	public Prodotto() {
	}

	public Prodotto(int id, String ean, String category, String model, String manufacturer, String description,
			String long_description, int sell) {
		super();
		this.id = id;
		this.ean = ean;
		this.category = category;
		this.model = model;
		this.manufacturer = manufacturer;
		this.description = description;
		this.long_description = long_description;
		this.sell_price = sell;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getEan() {
		return ean;
	}

	public void setEan(String ean) {
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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getLong_description() {
		return long_description;
	}

	public void setLong_description(String long_description) {
		this.long_description = long_description;
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

	public int getSell_price() {
		return sell_price;
	}

	public void setSell_price(int sell_price) {
		this.sell_price = sell_price;
	}

}
