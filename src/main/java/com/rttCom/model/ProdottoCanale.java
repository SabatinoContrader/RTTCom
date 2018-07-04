package com.rttCom.model;

import java.sql.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;



@Getter
@Setter

@Data
@NoArgsConstructor
@AllArgsConstructor

@Entity
public class ProdottoCanale {

	@Id
	@Column
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@ManyToOne
	@JoinColumn(name = "id_prodotto")
	private Prodotto prodotto;

	@ManyToOne
	@JoinColumn(name = "id_canale")
	private Canale canale;

	@NotNull
	@Column(name = "codice_prodotto_su_canale")
	private String codiceProdottoSuCanale;

	@Column
	private double quantita;

	@Column(name = "data_inizio")
	private Date dataInizio;

	@Column(name = "data_fine")
	private Date dataFine;

	@Column(name = "prezzo_vendita")
	private Double prezzoVendita;

}
