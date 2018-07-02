package com.rttCom.converter;

import org.springframework.stereotype.Component;

import com.rttCom.dto.UtenteDTO;
import com.rttCom.model.Utente;

@Component
public class UtenteConverter implements Converter<Utente, UtenteDTO>{

	@Override
	public Utente convertToEntity(UtenteDTO utenteDTO) {
		Utente utente = new Utente();
		utente.setId(utenteDTO.getId());
		utente.setUsername(utenteDTO.getUsername());
		utente.setPassword(utenteDTO.getPassword());
		utente.setNome(utenteDTO.getNome());
		utente.setCognome(utenteDTO.getCognome());
		return utente;
	}

	@Override
	public UtenteDTO convertToDTO(Utente utente) {
		return new UtenteDTO(utente.getId(), utente.getUsername(), utente.getPassword(),
				utente.getNome(), utente.getCognome());
	}
}
