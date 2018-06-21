package com.rttCom.rttCom.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity //???
@Table(name = "utente")  // mi serve per indicare il NOME della tabella strettamente legata alla classe UTENTE

public class Utente{
	
	@Id                                                    //Indico la primary Key a chi appartiene
	@GeneratedValue(strategy = GenerationType.IDENTITY)    // Indico la situazione di autoincremental
	@Column                                                // Indico che è una colonna della tabella
	private int id;
	@Column
    private String username;
	@Column
    private String password;
	@Column
    private String nome;
	@Column
    private String cognome;
	
	public Utente() { // perche è necessario creare un costruttore VUOTO????
    }

	public Utente(int id, String username, String password, String nome, String cognome) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.nome = nome;
		this.cognome = cognome;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
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

    
	
}
