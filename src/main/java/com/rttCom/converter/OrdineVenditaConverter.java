package com.rttCom.converter;


import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.rttCom.dto.OrdineVenditaDTO;
import com.rttCom.dto.ProdottoOrdineVenditaDTO;
import com.rttCom.model.OrdineVendita;
import com.rttCom.model.ProdottoOrdineVendita;
import com.rttCom.service.CanaleService;
import com.rttCom.service.ProdottoService;

@Component
public class OrdineVenditaConverter implements Converter<OrdineVendita, OrdineVenditaDTO> {
	
		private CanaleService canaleService;
		private ProdottoService prodottoService;
		private ProdottoOrdineVenditaConverter prodottoOrdineVenditaConverter;

		@Autowired
		public OrdineVenditaConverter(CanaleService canaleService, ProdottoService prodottoService, ProdottoOrdineVenditaConverter prodottoOrdineVenditaConverter) {
			this.canaleService = canaleService;	
			this.prodottoService = prodottoService;
			this.prodottoOrdineVenditaConverter = prodottoOrdineVenditaConverter;
		}
		
		@Override
		public OrdineVendita convertToEntity(OrdineVenditaDTO ordinevenditaDTO) {
			OrdineVendita ordinevendita = new OrdineVendita();
			ordinevendita.setStato(ordinevenditaDTO.getStato());
			ordinevendita.setCanale(canaleService.caricaById(ordinevenditaDTO.getId_canale()));
			if(ordinevenditaDTO.getProdottiOrdineVendita() != null)
				for(ProdottoOrdineVenditaDTO prodottoOrdineVenditaDTO : ordinevenditaDTO.getProdottiOrdineVendita())
					ordinevendita.getListaProdotti().add(prodottoOrdineVenditaConverter.convertToEntity(prodottoOrdineVenditaDTO));
			return ordinevendita;
		}

		@Override
		public OrdineVenditaDTO convertToDTO(OrdineVendita entity) {
			// TODO Auto-generated method stub
			return null;
		}

		// DA IMPLEMENTARE !!!
		
		/*
		 * @Override
		public OrdineVenditaDTO convertToDTO(OrdineVendita ordinevendita) {
			List<ProdottoOrdineVendita> listaprodotti=  new ArrayList<ProdottoOrdineVendita>();
			List<ProdottoOrdineVenditaDTO> listaprodottiDTO=  new ArrayList<ProdottoOrdineVenditaDTO>();
				listaprodotti=ordinevendita.getListaProdotti();
				ProdottoOrdineVenditaConverter con=new ProdottoOrdineVenditaConverter();
				for(ProdottoOrdineVendita prodottoordinevendita: listaprodotti) {
					ProdottoOrdineVenditaDTO prodottoDTO=con.convertToDTO(prodottoordinevendita);
					listaprodottiDTO.add(prodottoDTO);
					
				}
	
			return new OrdineVenditaDTO(ordinevendita.getStato(),ordinevendita.getCanale().getId(), listaprodottiDTO);
		}*/
	}


