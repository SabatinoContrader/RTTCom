package com.rttCom.dao;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.rttCom.model.Utente;

@Repository
@Transactional
public interface UtenteRepository extends CrudRepository<Utente, Long>{ 
	
	Utente findByUsername(String username);
	
	Utente save(Utente utente);
	
	@Modifying
    @Query("UPDATE Utente SET password=?1 WHERE username=?2")
	void updateUtente(String newpassword, String username);

}
