package com.rttCom.rttCom.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.rttCom.rttCom.service.LoginService;

@Controller
@RequestMapping("/utente")
public class LoginTraderController {
	
	private LoginService loginService;
	
	@Autowired
	public LoginTraderController (LoginService loginService) {
        this.loginService = loginService;
    }

	@RequestMapping(value="/logintraderControl", method = RequestMethod.POST)
    public String loginController (@RequestParam("username") String nomeUtente, @RequestParam("password") String password, HttpServletRequest request, Map<String, Object> model) {
		
		if (loginService.login(nomeUtente, password)) {
            	
                HttpSession session = request.getSession(true);
                session.setAttribute("utente", nomeUtente);
                return "home";
            }
            else {
   
                return "index";
            }
            
        }
	
}
