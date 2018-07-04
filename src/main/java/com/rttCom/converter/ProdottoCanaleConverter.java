package com.rttCom.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.rttCom.dto.ProdottoCanaleDTO;
import com.rttCom.model.ProdottoCanale;
import com.rttCom.service.CanaleService;
import com.rttCom.service.ProdottoService;

@Component
public class ProdottoCanaleConverter implements Converter<ProdottoCanale, ProdottoCanaleDTO> {

	private CanaleService canaleService;
	private ProdottoService prodottoService;

	@Autowired
	public ProdottoCanaleConverter(CanaleService canaleService, ProdottoService prodottoService) {
		this.canaleService = canaleService;	
		this.prodottoService = prodottoService;		
	}
	
	@Override
	public ProdottoCanale convertToEntity(ProdottoCanaleDTO prodottoCanaleDTO) {
		ProdottoCanale prodottoCanale = new ProdottoCanale();
		prodottoCanale.setCanale(canaleService.caricaById(prodottoCanaleDTO.getIdCanale()));
		prodottoCanale.setProdotto(prodottoService.getProdottoById(prodottoCanaleDTO.getIdProdotto()));
		prodottoCanale.setCodiceProdottoSuCanale(prodottoCanaleDTO.getCodiceProdottoSuCanale());
		prodottoCanale.setDataInizio(prodottoCanaleDTO.getDataInizio());
		prodottoCanale.setDataFine(prodottoCanaleDTO.getDataFine());
		prodottoCanale.setPrezzoVendita(prodottoCanaleDTO.getPrezzoVendita());
		prodottoCanale.setQuantita(prodottoCanaleDTO.getQuantita());
		return prodottoCanale;
	}
	
	
	@Override
	public ProdottoCanaleDTO convertToDTO(ProdottoCanale prodottoCanale) {
		return new ProdottoCanaleDTO((prodottoCanale.getProdotto()).getId(),(prodottoCanale.getCanale()).getId(), prodottoCanale.getCodiceProdottoSuCanale(), prodottoCanale.getQuantita(),
				prodottoCanale.getDataInizio(), prodottoCanale.getDataFine(), prodottoCanale.getPrezzoVendita());
	}
}