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
	
	@Scheduled(fixedDelay = 6000000)
	@RequestMapping(value = "/elaboraOrdiniVenditaPagati", method = RequestMethod.GET)
	public void elaboraOrdiniVenditaPagati(){
	    System.out.println("Inizio elaborazione ordini di vendita pagati - " + System.currentTimeMillis() / 1000);
	    this.ordineService.elaboraOrdiniDiVenditaPagati();
	    System.out.println("Elaborazione ordini di vendita completata pagati - " + System.currentTimeMillis() / 1000);
	}

	@Scheduled(fixedDelay = 600000)
	@RequestMapping(value = "/elaboraOrdiniVenditaInoltrati", method = RequestMethod.GET)
	public void elaboraOrdiniVenditaInoltrati(){
	    System.out.println("Inizio elaborazione ordini di vendita inoltrati - " + System.currentTimeMillis() / 1000);
	    this.ordineService.elaboraOrdiniDiVenditaInoltrati();
	    System.out.println("Elaborazione ordini di vendita completata inoltrati - " + System.currentTimeMillis() / 1000);
	}
	
	@Scheduled(fixedDelay = 600000)
	@RequestMapping(value = "/elaboraOrdiniVenditaElaborati", method = RequestMethod.GET)
	public void elaboraOrdiniVenditaElaborati(){
	    System.out.println("Inizio elaborazione ordini di vendita elaborati - " + System.currentTimeMillis() / 1000);
	    this.ordineService.elaboraOrdiniDiVenditaElaborati();
	    System.out.println("Elaborazione ordini di vendita completata elaborati - " + System.currentTimeMillis() / 1000);
	}
	
	@Scheduled(fixedDelay = 600000)
	@RequestMapping(value = "/elaboraOrdiniVenditaSpediti", method = RequestMethod.GET)
	public void elaboraOrdiniVenditaSpediti(){
	    System.out.println("Inizio elaborazione ordini di vendita spediti - " + System.currentTimeMillis() / 1000);
	    this.ordineService.elaboraOrdiniDiVenditaSpediti();
	    System.out.println("Elaborazione ordini di vendita completata spediti - " + System.currentTimeMillis() / 1000);
	}
	@Scheduled(fixedDelay = 600000)
	@RequestMapping(value = "/elaboraOrdiniVenditaConsegnati", method = RequestMethod.GET)
	public void elaboraOrdiniVenditaConsegnati(){
	    System.out.println("Inizio elaborazione ordini di vendita consegnati - " + System.currentTimeMillis() / 1000);
	    this.ordineService.elaboraOrdiniDiVenditaConsegnati();
	    System.out.println("Elaborazione ordini di vendita completata consegnati - " + System.currentTimeMillis() / 1000);
	}
	
	
}
