package com.rttCom.controller;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.rttCom.GenericResponse;
import com.rttCom.converter.ProdottoCanaleConverter;
import com.rttCom.converter.ProdottoConverter;
import com.rttCom.dto.ProdottoCanaleDTO;
import com.rttCom.dto.ProdottoDTO;
import com.rttCom.dto.UtenteDTO;
import com.rttCom.model.Canale;
import com.rttCom.model.Prodotto;
import com.rttCom.model.ProdottoCanale;
import com.rttCom.model.Utente;
import com.rttCom.service.CanaleService;
import com.rttCom.service.ProdottoService;

@CrossOrigin(value = "*")
@RestController
@RequestMapping("/prodotto")
public class ProdottoController {

	private ProdottoService prodottoService;
	private ProdottoConverter prodottoConverter;
	private ProdottoCanaleConverter prodottoCanaleConverter;
	private CanaleService canaleService;

	@Autowired
	public ProdottoController(ProdottoService prodottoService, ProdottoConverter prodottoConverter, ProdottoCanaleConverter prodottoCanaleConverter, CanaleService canaleService) {
		this.prodottoService = prodottoService;
		this.prodottoConverter = prodottoConverter;
		this.prodottoCanaleConverter = prodottoCanaleConverter;
		this.canaleService = canaleService;
	}
	
	
	@RequestMapping(value = "/ritornaProdotti", method = RequestMethod.GET)
	public GenericResponse<List<ProdottoDTO>> ritornaProdotti() {

		List<Prodotto> prodotti = new ArrayList<Prodotto>();
		List<ProdottoDTO> prodottiDTO = new ArrayList<>();
		prodotti = prodottoService.getAllProdotti();
		for (Prodotto prodotto : prodotti) {
			ProdottoDTO prodottoDTO = prodottoConverter.convertToDTO(prodotto);
			prodottiDTO.add(prodottoDTO);
		}

		return new GenericResponse<>(1, prodottiDTO);
	}

	@RequestMapping(value = "/insertProdotto", method = RequestMethod.POST)
	public /*GenericResponse<List<ProdottoDTO>>*/ List<ProdottoDTO> insertProdotti(@RequestBody ProdottoDTO prodottoDTO) {
		boolean result;
		int id;
		// id=prodottoDTO.getId()
		Prodotto prodotto = prodottoConverter.convertToEntity(prodottoDTO);
		result = prodottoService.insert(prodotto);
		if (result) {
			List<Prodotto> prodotti = new ArrayList<Prodotto>();
			List<ProdottoDTO> prodottiDTO = new ArrayList<>();
			prodotti = prodottoService.getAllProdotti();
			for (Prodotto prodotto1 : prodotti) {
				ProdottoDTO prodotto1DTO = prodottoConverter.convertToDTO(prodotto1);
				prodottiDTO.add(prodotto1DTO);
			}
			return prodottiDTO;
			//return new GenericResponse<>(1, prodottiDTO);
		} else
			return null;
			//return new GenericResponse<>(0, null);
	}

	@RequestMapping(value = "/EliminaProdotto", method = RequestMethod.GET)
	public /*GenericResponse<List<ProdottoDTO>>*/ List<ProdottoDTO> cancellaprodotto(@RequestParam("id") int id) {
		prodottoService.delete(id);
		List<Prodotto> prodotti = new ArrayList<Prodotto>();
		List<ProdottoDTO> prodottiDTO = new ArrayList<>();
		prodotti = prodottoService.getAllProdotti();
		for (Prodotto prodotto1 : prodotti) {
			ProdottoDTO prodotto1DTO = prodottoConverter.convertToDTO(prodotto1);
			prodottiDTO.add(prodotto1DTO);
		}
		//return new GenericResponse<>(1, prodottiDTO);
		return prodottiDTO;
	}

	@RequestMapping(value = "/SearchProdotto", method = RequestMethod.GET)
	public GenericResponse<List<ProdottoDTO>> searchprodotto(@RequestParam("colonna") String colonna,
			@RequestParam("campo") String campo) {
		List<Prodotto> prodottifiltrati = new ArrayList<Prodotto>();
		List<ProdottoDTO> prodottifiltratiDTO = new ArrayList<>();
		prodottifiltrati = prodottoService.search(colonna, campo);
		for (Prodotto prodotto1 : prodottifiltrati) {
			ProdottoDTO prodotto1DTO = prodottoConverter.convertToDTO(prodotto1);
			prodottifiltratiDTO.add(prodotto1DTO);
		}
		return new GenericResponse<>(1, prodottifiltratiDTO);
	}
	
	
}
