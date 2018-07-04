package com.rttCom.dto;

import javax.persistence.Column;

import com.rtt.Constants.StatoOrdineVendita;

import lombok.Data;

@Data
public class OrdineVenditaDTO {
	
	private StatoOrdineVendita stato;
	private int id_canale;
	private ProdottoOrdineVenditaDTO[] prodottiOrdineVendita;
	
}
