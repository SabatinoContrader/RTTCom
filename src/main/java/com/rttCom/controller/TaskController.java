package com.rttCom.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.rttCom.GenericResponse;
import com.rttCom.dto.ProdottoDTO;
import com.rttCom.model.Prodotto;
import com.rttCom.service.OrdineService;
import com.rttCom.service.ProdottoService;

@Component
@EnableScheduling
@CrossOrigin(value = "*")
@RestController
@RequestMapping("/task")
public class TaskController {
	
	private OrdineService ordineService;
	private ProdottoService prodottoService;
	
	@Autowired
	public TaskController(OrdineService ordineService) {
		this.ordineService = ordineService;
	}
	
	@Scheduled(fixedDelay = 60000)
	@RequestMapping(value = "/elaboraOrdiniVendita", method = RequestMethod.GET)
	public void elaboraOrdiniVendita(){
	    System.out.println("Inizio elaborazione ordini di vendita - " + System.currentTimeMillis() / 1000);
	    this.ordineService.elaboraOrdiniDiVendita();
	    System.out.println("Elaborazione ordini di vendita completata - " + System.currentTimeMillis() / 1000);
	}

}
