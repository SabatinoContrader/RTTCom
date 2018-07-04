package com.rttCom.controller;

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
import com.rttCom.converter.OrdineVenditaConverter;
import com.rttCom.dto.OrdineVenditaDTO;

import com.rttCom.model.OrdineVendita;
import com.rttCom.service.OrdineService;



@CrossOrigin(value = "*")
@RestController
@RequestMapping("/ordinevendita")
public class OrdineVenditaController {
	
	private OrdineService ordinevenditaService;
	private OrdineVenditaConverter ordinevenditaConverter;
	
	
	@Autowired
	public OrdineVenditaController(OrdineService ordineService, OrdineVenditaConverter ordinevenditaConverter) {
		this.ordinevenditaService = ordineService;
		this.ordinevenditaConverter = ordinevenditaConverter;
	}

	@RequestMapping(value = "/insertOrdineVendita", method = RequestMethod.POST)
	public boolean insertordinevendita(@RequestBody OrdineVenditaDTO ordinevenditaDTO) {
		OrdineVendita ordineVendita = ordinevenditaConverter.convertToEntity(ordinevenditaDTO);
		return ordinevenditaService.insert(ordineVendita);
	}
	
}
