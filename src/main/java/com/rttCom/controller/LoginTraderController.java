package com.rttCom.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.rttCom.GenericResponse;
import com.rttCom.converter.UtenteConverter;
import com.rttCom.dto.UtenteDTO;
import com.rttCom.model.Utente;
import com.rttCom.service.LoginService;

@CrossOrigin(value = "*")
@RestController
@RequestMapping("/login")
public class LoginTraderController {

	private LoginService loginService;
	private UtenteConverter utenteConverter;

	@Autowired
	public LoginTraderController(LoginService loginService, UtenteConverter utenteConverter) {
		this.loginService = loginService;
		this.utenteConverter = utenteConverter;
	}

	@RequestMapping(value = "/logintraderControl", method = RequestMethod.POST)
	public /*GenericResponse<UtenteDTO>*/ UtenteDTO loginController(@RequestBody UtenteDTO utenteDTO) {
		Utente utenteLogin = utenteConverter.convertToEntity(utenteDTO);
		Utente utente = loginService.login(utenteLogin.getUsername(),utenteLogin.getPassword());
		if (utente != null) {
			UtenteDTO Dutente = utenteConverter.convertToDTO(utente);
			return Dutente;
			//return new GenericResponse<>(1, Dutente);
		}
		else {
			return null;
			//return new GenericResponse<>(0, null);
		}
	}
}
