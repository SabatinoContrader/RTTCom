package com.rttCom.rttCom.model;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


/*
@Entity
@Table(name = "ordinefornitore")
public class OrdineFornitore  {
	
	
	@Id
	@Column
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(unique = true)
	private String stato;

	@Column
	private String destinatario;

	private List<ProdottoFornitoreOrdine> listaOrdini;
	
	public OrdineFornitore() { this.listaOrdini = new ArrayList<ProdottoFornitoreOrdine>();
	}

	public OrdineFornitore(int id, String stato, String destinatario) {
		super();
		this.id = id;
		this.stato = stato;
		this.destinatario = destinatario;
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getStato() {
		return stato;
	}

	public void setStato(String stato) {
		this.stato = stato;
	}

	public String getDestinatario() {
		return destinatario;
	}

	public void setDestinatario(String destinatario) {
		this.destinatario = destinatario;
	}
	
	
	 public void aggiungiAListaOrdini(ProdottoFornitoreOrdine prodottofornitoreordine){
	        listaOrdini.add(prodottofornitoreordine);
	    }
	
	

	
	  public void setorder(List<OrdineFornitore> ordini) {
		 
		 
	 }
	 
	 
	
	

}
*/