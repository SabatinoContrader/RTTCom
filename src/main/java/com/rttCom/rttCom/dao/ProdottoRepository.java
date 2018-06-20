package com.rttCom.rttCom.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.rttCom.rttCom.model.Prodotto;
import com.rttCom.rttCom.model.Utente;

@Repository
@Transactional
public interface ProdottoRepository extends CrudRepository<Prodotto, Long>{
	
	List<Prodotto> findAll();
	
}
