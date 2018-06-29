package com.rttCom.model;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor

@Entity
public class ProdottoFornitore {

	@Id
	@Column
	private int id_fornitore;

	@NotNull
	@Column(name = "codice_prodotto_su_fornitore")
	private String codiceProdottoSuFornitore;

	@Column
	private double quantita;

	@Column(name = "data_inizio")
	private Date dataInizio;

	@Column(name = "data_fine")
	private Date dataFine;

	@Column(name = "prezzo_acquisto")
	private Double prezzoAcquisto;

	@ManyToOne
	@JoinColumn(name = "idProdotto")
	private Prodotto prodotto;

	public ProdottoFornitore(int id_fornitore, String codiceProdottoSufornitore, double quantita, Date dataInizio,
			Date dataFine, Double prezzoAcquisto) {
		this.id_fornitore = id_fornitore;
		this.codiceProdottoSuFornitore = codiceProdottoSufornitore;
		this.quantita = quantita;
		this.dataInizio = dataInizio;
		this.dataFine = dataFine;
		this.prezzoAcquisto = prezzoAcquisto;
	}

}