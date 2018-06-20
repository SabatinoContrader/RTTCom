package com.rttCom.rttCom.dao;

import javax.transaction.Transactional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.rttCom.rttCom.model.Utente;

@Repository
@Transactional
public interface UtenteRepository extends CrudRepository<Utente, Long>{  // <Utente fa riferimento alla mia ENTITA, Tipo primitivo Long>
	
	Utente findByUsernameAndPassword(String username, String password);
	
	Utente save(Utente utente);

}
