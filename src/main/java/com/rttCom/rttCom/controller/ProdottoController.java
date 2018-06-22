package com.rttCom.rttCom.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

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
	
	@RequestMapping(value = "/insertProdotto", method = RequestMethod.POST)
	public String insertProdotti(HttpServletRequest request, Model model){
		Prodotto prodotto;
		boolean result;
		int id =Integer.parseInt(request.getParameter("id"));
		String ean = request.getParameter("ean");
        String category = request.getParameter("category");
        String modello = request.getParameter("model");
        String manufacturer = request.getParameter("manufacturer");
        String descrizione = request.getParameter("description");
        String descrizioneLunga = request.getParameter("long_description");
        double prezzoVendita = Double.parseDouble(request.getParameter("sell_price"));
        prodotto = new Prodotto(0, ean, category, modello, manufacturer, descrizione, descrizioneLunga, prezzoVendita);
        if (id==0) {
			result = prodottoService.insert(prodotto);
        }else {
        	result = prodottoService.updateProdotto(prodotto, id);
        	}
		if(!result) {
		model.addAttribute("result", "ko");
			return "insertProdotto";
		}
		model.addAttribute("result", "ok");
		
		model.addAttribute("listProdotti", prodottoService.getAllProdotti());
		return "listProdotti";
		
	}
	
	@RequestMapping(value = "/ModificaProdotto", method = RequestMethod.GET)
	public String modificaProdotti(@RequestParam("id") int id, Model model) {
	         model.addAttribute("prodotto",  this.prodottoService.getProdottoById(id));
	         return "insertProdotto";
	}

	@RequestMapping(value = "/EliminaProdotto", method = RequestMethod.GET) 
	public String cancellaprodotto(@RequestParam("id") int id, Model model) {
         this.prodottoService.delete(id);
         model.addAttribute("listProdotti", prodottoService.getAllProdotti());
         return "listProdotti";
		
	}
	
	
}
