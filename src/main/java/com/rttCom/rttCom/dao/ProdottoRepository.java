package com.rttCom.rttCom.dao;

import java.util.List;
import java.util.ArrayList;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.jca.cci.connection.*;

//import com.virtualpairprogrammers.utils.ConnectionSingleton;
//import com.virtualpairprogrammers.utils.GestoreEccezioni;

import com.rttCom.rttCom.model.Prodotto;



@Repository
@Transactional
public interface ProdottoRepository extends CrudRepository<Prodotto, Long>{
	
	List<Prodotto> findAll();
	
	Prodotto findByEan(String ean);
	
	Prodotto save(Prodotto prodotto);
		
	@Modifying
	@Query("UPDATE Prodotto SET ean=?1, category=?2, model=?3, manufacturer=?4, description=?5, long_description=?6, sell_price=?7 where id=?8")
	void updateProdotto(String ean, String category, String model, String manufacturer, String description, String longDescription, double sellPrice, int id);
	
	List<Prodotto> findByCategory(String category);
	
	Prodotto findById(int id);
	
	List<Prodotto> findByModel(String model);
	
	List<Prodotto> findByManufacturer(String manufacturer);
	
	//Prodotto findByDescription(String description);
	
	List<Prodotto> findBySellPrice(double sellPrice);
	
	@Modifying
	@Query("SELECT P FROM Prodotto P  WHERE sell_price>=?1 and sell_price<=?2")
	List<Prodotto> searchPriceforInterval(double pricemin, double pricemax);
	
	void deleteById(Integer id);
	
}