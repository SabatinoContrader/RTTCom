package com.rttCom.rttCom.model;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity 
@Table(name = "prodotto_fornitore")
public class ProdottoFornitore {
	
	@Id
	@Column
	private int id_fornitore;
	
	
	@Column
	@NotNull
    private String codice_prodotto_su_fornitore;
	
	@Column
    private double quantita;
	
	
	@Column
    private Date data_inizio;
	
	@Column
    private Date data_fine;
	
	@Column
    private Double prezz_acquisto;
    
    public ProdottoFornitore() {
    }

	public ProdottoFornitore(int id_fornitore, @NotNull String codice_prodotto_su_fornitore, double quantita,
			Date data_inizio, Date data_fine, Double prezz_acquisto) {
		super();
		this.id_fornitore = id_fornitore;
		this.codice_prodotto_su_fornitore = codice_prodotto_su_fornitore;
		this.quantita = quantita;
		this.data_inizio = data_inizio;
		this.data_fine = data_fine;
		this.prezz_acquisto = prezz_acquisto;
	}

	public int getId_fornitore() {
		return id_fornitore;
	}

	public void setId_fornitore(int id_fornitore) {
		this.id_fornitore = id_fornitore;
	}

	public String getCodice_prodotto_su_fornitore() {
		return codice_prodotto_su_fornitore;
	}

	public void setCodice_prodotto_su_fornitore(String codice_prodotto_su_fornitore) {
		this.codice_prodotto_su_fornitore = codice_prodotto_su_fornitore;
	}

	public double getQuantita() {
		return quantita;
	}

	public void setQuantita(double quantita) {
		this.quantita = quantita;
	}

	public Date getData_inizio() {
		return data_inizio;
	}

	public void setData_inizio(Date data_inizio) {
		this.data_inizio = data_inizio;
	}

	public Date getData_fine() {
		return data_fine;
	}

	public void setData_fine(Date data_fine) {
		this.data_fine = data_fine;
	}

	public Double getPrezz_acquisto() {
		return prezz_acquisto;
	}

	public void setPrezz_acquisto(Double prezz_acquisto) {
		this.prezz_acquisto = prezz_acquisto;
	}

	
    
}
