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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.rtt.Constants.StatoOrdineAcquisto;
import com.rtt.Constants.StatoOrdineVendita;

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
public class OrdineAcquisto {
	
	@Id
	@Column
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name="id_ordineacquisto", nullable=false, referencedColumnName="id")
	private List<ProdottoOrdineAcquisto> listaProdotti = new ArrayList<ProdottoOrdineAcquisto>();
	
	@ManyToOne
	@JoinColumn(name = "id_ordineVendita")
	private OrdineVendita ordineVendita;

	@ManyToOne
	@JoinColumn(name = "id_fornitore")
	private Fornitore fornitore;

	@Column
	private StatoOrdineAcquisto stato = StatoOrdineAcquisto.creato;
	
	public OrdineAcquisto(OrdineVendita ordineVendita, Fornitore fornitore) {
		this();
		this.ordineVendita = ordineVendita;
		this.fornitore = fornitore;
		this.stato = StatoOrdineAcquisto.creato;
	}

}
