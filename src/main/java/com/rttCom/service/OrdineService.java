package com.rttCom.service;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rtt.Constants.StatoOrdineAcquisto;
import com.rtt.Constants.StatoOrdineVendita;
import com.rttCom.dao.OrdineAcquistoRepository;
import com.rttCom.dao.OrdineVenditaRepository;
import com.rttCom.dao.ProdottoRepository;
import com.rttCom.model.Fornitore;
import com.rttCom.model.OrdineAcquisto;
import com.rttCom.model.OrdineVendita;
import com.rttCom.model.Prodotto;

import java.sql.Date;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.rttCom.dao.UtenteRepository;
//import com.rttCom.model.Fornitore;

import com.rttCom.model.ProdottoFornitore;
import com.rttCom.model.ProdottoOrdineAcquisto;
import com.rttCom.model.ProdottoOrdineVendita;
import com.rttCom.model.Utente;


@Service
public class OrdineService {

	private OrdineAcquistoRepository ordineAcquistoRepository;
	private OrdineVenditaRepository ordineVenditaRepository;

	@Autowired
	public OrdineService(OrdineAcquistoRepository ordineAcquistoRepository, OrdineVenditaRepository ordineVenditaRepository) {
		this.ordineAcquistoRepository = ordineAcquistoRepository;
		this.ordineVenditaRepository = ordineVenditaRepository;
	}

	public void elaboraOrdiniDiVendita() {
		List<OrdineVendita> ordiniVendita = ordineVenditaRepository.findByStato(StatoOrdineVendita.creato);
		List<OrdineAcquisto> ordiniAcquisto = new ArrayList<OrdineAcquisto>();
		for (OrdineVendita ordineVendita : ordiniVendita) {
			List<ProdottoOrdineVendita> prodottiOrdineVendita = ordineVendita.getListaProdotti();
			for (ProdottoOrdineVendita prodottoOrdineVendita : prodottiOrdineVendita) {
				Prodotto prodotto = prodottoOrdineVendita.getProdotto();
				Fornitore fornitoreSelezionato = prodotto.getFornitoreSelezionato();
				// Vedere se c'è già un ordine allo stesso fornitore
				OrdineAcquisto ordineAcquisto = new OrdineAcquisto(prodottoOrdineVendita.getOrdineVendita(), fornitoreSelezionato);
				ordineAcquisto.getListaProdotti().add(new ProdottoOrdineAcquisto(prodotto, prodottoOrdineVendita.getQuantita(), prodotto.getPrezzoAcquisto()));
				ordiniAcquisto.add(ordineAcquisto);
			}
			ordineVendita.setStato(StatoOrdineVendita.elaborato);
		}
		ordineAcquistoRepository.saveAll(ordiniAcquisto);
		ordineVenditaRepository.saveAll(ordiniVendita);
	}
	
}
