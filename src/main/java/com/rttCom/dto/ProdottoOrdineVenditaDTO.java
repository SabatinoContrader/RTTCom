package com.rttCom.dto;

import java.sql.Date;

import lombok.Data;

@Data
public class ProdottoOrdineVenditaDTO {
	
	private int idProdotto;
	private double quantita;
	private double prezzoVendita;
	
	
	
	
public ProdottoOrdineVenditaDTO() {
		
	}
	
	
	public ProdottoOrdineVenditaDTO(int idProdotto, double quantita, double prezzovendita) {
		this.idProdotto = idProdotto;
		this.quantita = quantita;
		this.prezzoVendita = prezzovendita;
	}
}
