package com.rttCom.rttCom.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity 
@Table(name = "destinatario")  
public class Destinatario {
	
	@Id                                                   
	@Column                                                
	private int id_destinatario;
	
	@Column
    private String nome;
	
	@Column
    private String cognome;
	
	@Column
    private String indirizzo;
	
	@Column
    private String cod_fiscale;
	
	@Column
	private String email;
	
	@Column
	private int telefono;
	 
	//private List<ProdottoOrdine> ordine;
	
	public Destinatario() {
	}

	public Destinatario(int id_destinatario, String nome, String cognome, String indirizzo, String cod_fiscale,
			String email, int telefono) {
		super();
		this.id_destinatario = id_destinatario;
		this.nome = nome;
		this.cognome = cognome;
		this.indirizzo = indirizzo;
		this.cod_fiscale = cod_fiscale;
		this.email = email;
		this.telefono = telefono;
	}

	public int getId_destinatario() {
		return id_destinatario;
	}

	public void setId_destinatario(int id_destinatario) {
		this.id_destinatario = id_destinatario;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCognome() {
		return cognome;
	}

	public void setCognome(String cognome) {
		this.cognome = cognome;
	}

	public String getIndirizzo() {
		return indirizzo;
	}

	public void setIndirizzo(String indirizzo) {
		this.indirizzo = indirizzo;
	}

	public String getCod_fiscale() {
		return cod_fiscale;
	}

	public void setCod_fiscale(String cod_fiscale) {
		this.cod_fiscale = cod_fiscale;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getTelefono() {
		return telefono;
	}

	public void setTelefono(int telefono) {
		this.telefono = telefono;
	}
	
}
