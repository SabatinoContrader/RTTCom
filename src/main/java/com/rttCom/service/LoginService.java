package com.rttCom.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rttCom.dao.UtenteRepository;
import com.rttCom.model.Utente;

@Service
public class LoginService {

	private UtenteRepository utenteRepository;

	@Autowired
	public LoginService(UtenteRepository utenteRepository) {
		this.utenteRepository = utenteRepository;
	}

	public Utente login(String username, String password) {
		Utente utente = utenteRepository.findByUsername(username);
		if (utente == null) {
			return null;
		} else {
			if (utente.getPassword().equals(password))
				return utente;
			else
				return null;
		}
	}

	public Utente insert(Utente utente) {
		return this.utenteRepository.save(utente);
	}

	public boolean pswmodify(String username, String newpassword) {
		Utente utente = utenteRepository.findByUsername(username);
		if (utente.getUsername().equals(username)) {
			utenteRepository.updateUtente(newpassword, utente.getUsername());
			return true;
		} else
			return false;

	}

}
