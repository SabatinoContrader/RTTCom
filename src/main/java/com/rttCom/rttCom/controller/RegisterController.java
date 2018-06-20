package com.rttCom.rttCom.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.rttCom.rttCom.model.Utente;
import com.rttCom.rttCom.service.LoginService;

@Controller
@RequestMapping("/utente")
public class RegisterController {
	
	private LoginService loginService;
	
	@Autowired
	public RegisterController (LoginService loginService) {
        this.loginService = loginService;
    }

	@RequestMapping(value="/registerControl", method = RequestMethod.POST)
    public String RegisterController (@RequestParam("username") String username, @RequestParam("password") String password, @RequestParam("nome") String nome, @RequestParam("cognome") String cognome, HttpServletRequest request, Map<String, Object> model) {
		
	
        if (username != null || password != null || nome != null || cognome != null) {
            if (loginService.insert(new Utente(0, username, password, nome, cognome)) != null)
                return "index";
            else
                return "register";
        }
        return "register";
            
        }
}
