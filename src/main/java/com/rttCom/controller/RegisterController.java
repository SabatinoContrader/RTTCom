package com.rttCom.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.rttCom.GenericResponse;
import com.rttCom.converter.UtenteConverter;
import com.rttCom.dto.UtenteDTO;
import com.rttCom.model.Utente;
import com.rttCom.service.LoginService;

@CrossOrigin(value = "*")
@RestController
@RequestMapping("/utente")
public class RegisterController {
	
    private LoginService loginService;
    private UtenteConverter utenteConverter;
	
	@Autowired
	public RegisterController (LoginService loginService, UtenteConverter utenteConverter) {
        this.loginService = loginService;
        this.utenteConverter = utenteConverter;
    }

	@RequestMapping(value="/registerControl", method = RequestMethod.POST)
    public GenericResponse<UtenteDTO> RegisterController (@RequestBody UtenteDTO utenteDTO) {
		
		Utente utenteRegister = utenteConverter.convertToEntity(utenteDTO);	
		if (utenteRegister.getUsername() != null || utenteRegister.getPassword() != null || utenteRegister.getNome() != null || utenteRegister.getCognome() != null) {
            Utente utente = (loginService.insert(new Utente(0, utenteRegister.getUsername(),utenteRegister.getPassword(), utenteRegister.getNome(), utenteRegister.getCognome())));
            UtenteDTO newDTOutente = utenteConverter.convertToDTO(utente);
            return new GenericResponse<>(1, newDTOutente);
		}else
          return new GenericResponse<>(0, null);
    }

}
