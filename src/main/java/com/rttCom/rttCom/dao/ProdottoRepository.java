package com.rttCom.rttCom.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.rttCom.rttCom.model.Prodotto;
import com.rttCom.rttCom.model.Utente;

@Repository
@Transactional
public interface ProdottoRepository extends CrudRepository<Prodotto, Long>{
	
	List<Prodotto> findAll();
	
	Prodotto findByEan(String ean);
	
	Prodotto save(Prodotto prodotto);
	
	Prodotto findById(int id);
	
	
	@Modifying
	@Query("UPDATE Prodotto SET ean=?1, category=?2, model=?3, manufacturer=?4, description=?5, long_description=?6, sell_price=?7 where id=?8")
	void updateProdotto(String ean, String category, String model, String manufacturer, String description, String long_description, double sell_price, int id);
	
	void deleteById(Integer id);
	
}