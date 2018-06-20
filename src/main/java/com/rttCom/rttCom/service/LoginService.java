package com.rttCom.rttCom.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rttCom.rttCom.dao.UtenteRepository;
import com.rttCom.rttCom.model.Utente;

@Service
public class LoginService {
	
	private UtenteRepository utenteRepository;
	
	@Autowired                                                 // vale come fac-smile dell'operazione NEW quando creiamo un oggetto di una classe
	public LoginService(UtenteRepository utenteRepository) {
        this.utenteRepository = utenteRepository;
    }
	
	public Boolean login (String username, String password) {
		Utente utente = utenteRepository.findByUsernameAndPassword(username, password);
        if(utente == null){
            return false;
        }else{
            if(utente.getPassword().equals(password)) return true;
            else return false;
        }
	}
	
	public Utente insert(Utente utente) {
		return this.utenteRepository.save(utente);
	}
}
