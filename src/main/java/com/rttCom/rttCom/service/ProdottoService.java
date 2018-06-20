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
	
}
