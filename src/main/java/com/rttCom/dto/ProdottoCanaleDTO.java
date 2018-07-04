package com.rttCom.dto;
import java.sql.Date;

import lombok.Data;

@Data

public class ProdottoCanaleDTO {

	private int idProdotto;
	private int idCanale;
	private String codiceProdottoSuCanale;
	private double quantita;
	private Date dataInizio;
	private Date dataFine;
	private double prezzoVendita;
	
	
	public ProdottoCanaleDTO() {
		
	}
	
	
	public ProdottoCanaleDTO(int idProdotto, int idCanale, String codiceprodottosucanale, double quantita, Date datainizio, Date datafine,
		Double prezzovendita) {
		this.idProdotto = idProdotto;
		this.idCanale = idCanale;
		this.codiceProdottoSuCanale = codiceprodottosucanale;
		this.quantita = quantita;
		this.dataInizio = datainizio;
		this.dataFine = datafine;
		this.prezzoVendita = prezzovendita;
	}
	
}
