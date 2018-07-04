package com.rttCom.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.rttCom.dto.ProdottoCanaleDTO;
import com.rttCom.dto.ProdottoOrdineVenditaDTO;
import com.rttCom.model.ProdottoCanale;
import com.rttCom.model.ProdottoOrdineVendita;
import com.rttCom.service.CanaleService;
import com.rttCom.service.ProdottoService;

@Component
public class ProdottoOrdineVenditaConverter implements Converter<ProdottoOrdineVendita, ProdottoOrdineVenditaDTO> {

	private CanaleService canaleService;
	private ProdottoService prodottoService;

	@Autowired
	public ProdottoOrdineVenditaConverter(CanaleService canaleService, ProdottoService prodottoService) {
		this.canaleService = canaleService;	
		this.prodottoService = prodottoService;		
	}
	
	public ProdottoOrdineVenditaConverter() {
			
	}
	
	@Override
	public ProdottoOrdineVendita convertToEntity(ProdottoOrdineVenditaDTO prodottoOrdineVenditaDTO) {
		ProdottoOrdineVendita prodottoOrdineVendita = new ProdottoOrdineVendita();
		prodottoOrdineVendita.setProdotto(prodottoService.getProdottoById(prodottoOrdineVenditaDTO.getIdProdotto()));
		prodottoOrdineVendita.setQuantita(prodottoOrdineVenditaDTO.getQuantita());
		prodottoOrdineVendita.setPrezzoVendita(prodottoOrdineVenditaDTO.getPrezzoVendita());
		return prodottoOrdineVendita;
	}

	
	@Override
	public ProdottoOrdineVenditaDTO convertToDTO(ProdottoOrdineVendita prodottoCanale) {
		return new ProdottoOrdineVenditaDTO((prodottoCanale.getProdotto()).getId(),prodottoCanale.getQuantita(), prodottoCanale.getPrezzoVendita());
	}
}