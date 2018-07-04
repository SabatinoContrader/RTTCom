package com.rttCom.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.rttCom.model.Prodotto;
import com.rttCom.model.ProdottoCanale;

@Repository
@Transactional
public interface ProdottoCanaleRepository extends CrudRepository<ProdottoCanale, Long> {

	ProdottoCanale findById(int id);
	
	void deleteById(Integer id);
	
	
}
