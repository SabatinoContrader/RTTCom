package com.rttCom.rttCom.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.rttCom.rttCom.model.Prodotto;
import com.rttCom.rttCom.service.ProdottoService;

@Controller
@RequestMapping("/prodotto")
public class ProdottoController {

	private ProdottoService prodottoService;

	@Autowired
	public ProdottoController(ProdottoService prodottoService) {
		this.prodottoService = prodottoService;
	}

	@RequestMapping(value = "/ritornaProdotti", method = RequestMethod.GET) 
	
	public String ritornaProdotti(Model model) {
		
		List<Prodotto> prodotti = new ArrayList<Prodotto>();
		prodotti = prodottoService.getAllProdotti();
		model.addAttribute("listProdotti", prodotti);
		return "listProdotti";
	}

}
