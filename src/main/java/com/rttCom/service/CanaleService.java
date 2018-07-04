package com.rttCom.service;

import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rttCom.dao.CanaleRepository;
import com.rttCom.dao.ProdottoCanaleRepository;
import com.rttCom.dao.ProdottoRepository;
import com.rttCom.dto.ProdottoCanaleDTO;
import com.rttCom.model.Canale;
import com.rttCom.model.Prodotto;
import com.rttCom.model.ProdottoCanale;

@Service
public class CanaleService {
	
	private ProdottoRepository prodottoRepository;
	private ProdottoCanaleRepository prodottocanaleRepository;
	private CanaleRepository canalerepository;

	@Autowired
	public CanaleService(ProdottoRepository prodottoRepository, ProdottoCanaleRepository prodottocanaleRepository, CanaleRepository canalerepository) {
		this.prodottoRepository = prodottoRepository;
		this.prodottocanaleRepository = prodottocanaleRepository;
		this.canalerepository = canalerepository;
	}
	
	public Canale caricaById(int idCanale) {
		return canalerepository.findById(idCanale);		
	}
	
	
	public int sellProduct(List<ProdottoCanale> prodottiCanale)
	{
		prodottocanaleRepository.saveAll(prodottiCanale);
		return 0;
	}
}
