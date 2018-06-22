package com.rttCom.rttCom.service;

import java.sql.Date;
import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rttCom.rttCom.dao.ProdottoRepository;
import com.rttCom.rttCom.dao.UtenteRepository;
import com.rttCom.rttCom.model.Fornitore;
import com.rttCom.rttCom.model.Prodotto;
import com.rttCom.rttCom.model.ProdottoFornitore;

@Service
public class ProdottoService {
	
	private ProdottoRepository prodottoRepository;
	
	@Autowired                                                
	public ProdottoService(ProdottoRepository prodottoRepository) {
        this.prodottoRepository = prodottoRepository;
    }
	
	public List<Prodotto> getAllProdotti () {
        return this.prodottoRepository.findAll();
    }
	
	public boolean insert(Prodotto prodotto) {
			prodottoRepository.save(prodotto);
			return true;
	}
	
	public boolean updateProdotto(Prodotto prodotto, int id) {
		prodottoRepository.updateProdotto(prodotto.getEan(), prodotto.getCategory(), prodotto.getModel(), prodotto.getManufacturer(), prodotto.getDescription(), prodotto.getLong_description(), prodotto.getSell_price(), id);
		return true;
	}
	
	public Prodotto getProdottoById(int id) {
		Prodotto prodotto=prodottoRepository.findById(id);
		return prodotto;
	}
	
	public void delete(int id) {
		prodottoRepository.deleteById(id);
	}
	
}
