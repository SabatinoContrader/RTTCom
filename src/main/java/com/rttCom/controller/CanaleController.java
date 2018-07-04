package com.rttCom.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.rttCom.converter.OrdineVenditaConverter;
import com.rttCom.converter.ProdottoCanaleConverter;
import com.rttCom.converter.ProdottoConverter;
import com.rttCom.dto.OrdineVenditaDTO;
import com.rttCom.dto.ProdottoCanaleDTO;
import com.rttCom.model.OrdineVendita;
import com.rttCom.model.ProdottoCanale;
import com.rttCom.service.CanaleService;
import com.rttCom.service.OrdineService;
import com.rttCom.service.ProdottoService;


@CrossOrigin(value = "*")
@RestController
@RequestMapping("/canale")
public class CanaleController {

	private ProdottoService prodottoService;
	private ProdottoConverter prodottoConverter;
	private ProdottoCanaleConverter prodottoCanaleConverter;
	private CanaleService canaleService;
	private OrdineService ordinevenditaService;
	private OrdineVenditaConverter ordinevenditaConverter;

	@Autowired
	public CanaleController(OrdineService ordineService, OrdineVenditaConverter ordinevenditaConverter,ProdottoService prodottoService, ProdottoConverter prodottoConverter, ProdottoCanaleConverter prodottoCanaleConverter, CanaleService canaleService) 
		{
			
		this.ordinevenditaService = ordineService;
		this.ordinevenditaConverter = ordinevenditaConverter;
		this.prodottoService = prodottoService;
		this.prodottoConverter = prodottoConverter;
		this.prodottoCanaleConverter = prodottoCanaleConverter;
		this.canaleService = canaleService;
	
		}
	
	
	
	
	@RequestMapping(value = "/insertOrdineVendita", method = RequestMethod.POST)
		public boolean insertordinevendita(@RequestBody OrdineVenditaDTO ordinevenditaDTO) {
			OrdineVendita ordineVendita = ordinevenditaConverter.convertToEntity(ordinevenditaDTO);
			return ordinevenditaService.insert(ordineVendita);
		}
	
	
	
	@RequestMapping(value = "/sellProdotti", method = RequestMethod.POST)
	public int sellProdotti(@RequestBody ProdottoCanaleDTO[] prodottiCanaleDTO)
	{
		List<ProdottoCanale> prodottiCanale = new ArrayList<ProdottoCanale>();
		for(ProdottoCanaleDTO prodottoCanaleDTO : prodottiCanaleDTO)
			prodottiCanale.add(prodottoCanaleConverter.convertToEntity(prodottoCanaleDTO));
		return canaleService.sellProduct(prodottiCanale);
	}
	
}
