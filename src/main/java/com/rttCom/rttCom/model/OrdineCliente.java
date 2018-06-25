package com.rttCom.rttCom.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ordine_cliente")
public class OrdineCliente {
	
	@Id
	@Column
	private int id_ordine;
	@Column
	private int id_canale;
	@Column
	private String stato;
	@Column
	private int destinatario;
	
	public OrdineCliente() {
	}
	
	public OrdineCliente(int id_ordine, int id_canale, String stato, int destinatario) {
		super();
		this.id_ordine = id_ordine;
		this.id_canale = id_canale;
		this.stato = stato;
		this.destinatario = destinatario;
	}

	public int getId_ordine() {
		return id_ordine;
	}

	public void setId_ordine(int id_ordine) {
		this.id_ordine = id_ordine;
	}

	public int getId_canale() {
		return id_canale;
	}

	public void setId_canale(int id_canale) {
		this.id_canale = id_canale;
	}

	public String getStato() {
		return stato;
	}

	public void setStato(String stato) {
		this.stato = stato;
	}

	public int getDestinatario() {
		return destinatario;
	}

	public void setDestinatario(int destinatario) {
		this.destinatario = destinatario;
	}

}
