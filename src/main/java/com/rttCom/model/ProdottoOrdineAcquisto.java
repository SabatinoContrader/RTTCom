package com.rttCom.model;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

@Entity
public class ProdottoOrdineAcquisto {

	@Id
	@Column
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@ManyToOne
	@JoinColumn(name = "id_ordineacquisto")
	private OrdineAcquisto ordineAcquisto;
	
	@ManyToOne
	@JoinColumn(name = "id_prodotto")
	private Prodotto prodotto;

	@Column
	private double quantita;

	@Column(name = "prezzo_acquisto")
	private Double prezzoAcquisto;
	
	public ProdottoOrdineAcquisto(Prodotto prodotto, double quantita, double prezzoAcquisto) {
		this();
		this.prodotto = prodotto;
		this.quantita = quantita;
		this.prezzoAcquisto = prezzoAcquisto;
	}
	
}
