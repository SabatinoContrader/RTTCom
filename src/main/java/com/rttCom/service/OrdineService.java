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
	
	public void elaboraOrdiniDiVenditaInoltrati() {
		List<OrdineVendita> ordiniVendita = ordineVenditaRepository.findByStato(StatoOrdineVendita.inoltrato);
		for (OrdineVendita ordineVendita : ordiniVendita) {
			List<OrdineAcquisto> ordiniAcquisto = ordineVendita.getListaOrdiniAcquisto();
			for(OrdineAcquisto ordineAcquisto: ordiniAcquisto) {
				if(ordineAcquisto.getStato() == StatoOrdineAcquisto.creato) {
					ordineVendita.setStato(StatoOrdineVendita.inoltrato);
					break;
				}
				else if(ordineAcquisto.getStato() == StatoOrdineAcquisto.rifiutato || ordineAcquisto.getStato() == StatoOrdineAcquisto.annullato) {
					ordineVendita.setStato(StatoOrdineVendita.parzialmenteElaborato);
					break;
				}
				else {
					ordineVendita.setStato(StatoOrdineVendita.elaborato);
				}
			}
		}
		ordineVenditaRepository.saveAll(ordiniVendita);
	}
	
	public void elaboraOrdiniDiVenditaElaborati() {
		List<OrdineVendita> ordiniVendita = ordineVenditaRepository.findByStato(StatoOrdineVendita.elaborato);
		for (OrdineVendita ordineVendita : ordiniVendita) {
			List<OrdineAcquisto> ordiniAcquisto = ordineVendita.getListaOrdiniAcquisto();
			for(OrdineAcquisto ordineAcquisto: ordiniAcquisto) {
				if(ordineAcquisto.getStato() == StatoOrdineAcquisto.creato) {
					ordineVendita.setStato(StatoOrdineVendita.inoltrato);
					break;
				}
				else if (ordineAcquisto.getStato() == StatoOrdineAcquisto.accettato || ordineAcquisto.getStato() == StatoOrdineAcquisto.pagato) {
					ordineVendita.setStato(StatoOrdineVendita.elaborato);
					break;
				}
				else if(ordineAcquisto.getStato() == StatoOrdineAcquisto.rifiutato || ordineAcquisto.getStato() == StatoOrdineAcquisto.annullato ) {
					ordineVendita.setStato(StatoOrdineVendita.parzialmenteSpedito);
					break;
				}
				else {
					ordineVendita.setStato(StatoOrdineVendita.spedito);
				}
			}
		}
		ordineVenditaRepository.saveAll(ordiniVendita);
	}

	public void elaboraOrdiniDiVenditaSpediti() {
		List<OrdineVendita> ordiniVendita = ordineVenditaRepository.findByStato(StatoOrdineVendita.spedito);
		for (OrdineVendita ordineVendita : ordiniVendita) {
			List<OrdineAcquisto> ordiniAcquisto = ordineVendita.getListaOrdiniAcquisto();
			for(OrdineAcquisto ordineAcquisto: ordiniAcquisto) {
				if(ordineAcquisto.getStato() == StatoOrdineAcquisto.creato) {
					ordineVendita.setStato(StatoOrdineVendita.inoltrato);
					break;
				}
				else if (ordineAcquisto.getStato() == StatoOrdineAcquisto.accettato || ordineAcquisto.getStato() == StatoOrdineAcquisto.pagato) {
					ordineVendita.setStato(StatoOrdineVendita.elaborato);
					break;
				}
				else if (ordineAcquisto.getStato()== StatoOrdineAcquisto.spedito) {
					ordineVendita.setStato(StatoOrdineVendita.spedito);
					break;
				}
				else if(ordineAcquisto.getStato() == StatoOrdineAcquisto.rifiutato || ordineAcquisto.getStato() == StatoOrdineAcquisto.annullato) {
					ordineVendita.setStato(StatoOrdineVendita.parzialmenteConsegnato);
					break;
				}
				else {
					ordineVendita.setStato(StatoOrdineVendita.consegnato);
				}
			}
		}
		ordineVenditaRepository.saveAll(ordiniVendita);
	}
	
	
	public void elaboraOrdiniDiVenditaConsegnati() {
		List<OrdineVendita> ordiniVendita = ordineVenditaRepository.findByStato(StatoOrdineVendita.consegnato);
		for (OrdineVendita ordineVendita : ordiniVendita) {
			List<OrdineAcquisto> ordiniAcquisto = ordineVendita.getListaOrdiniAcquisto();
			for(OrdineAcquisto ordineAcquisto: ordiniAcquisto) {
				if(ordineAcquisto.getStato() == StatoOrdineAcquisto.creato) {
					ordineVendita.setStato(StatoOrdineVendita.inoltrato);
					break;
				}
				else if (ordineAcquisto.getStato() == StatoOrdineAcquisto.accettato || ordineAcquisto.getStato() == StatoOrdineAcquisto.pagato) {
					ordineVendita.setStato(StatoOrdineVendita.elaborato);
					break;
				}
				else if(ordineAcquisto.getStato() == StatoOrdineAcquisto.rifiutato || ordineAcquisto.getStato() == StatoOrdineAcquisto.annullato ) {
					ordineVendita.setStato(StatoOrdineVendita.spedito);
					break;
				}
				else {
					ordineVendita.setStato(StatoOrdineVendita.chiuso);
				}
			}
		}
		ordineVenditaRepository.saveAll(ordiniVendita);
	}
	
	
	
	
	public void elaboraOrdiniDiVenditaPagati() {
		List<OrdineVendita> ordiniVendita = ordineVenditaRepository.findByStato(StatoOrdineVendita.pagato);
		List<OrdineAcquisto> ordiniAcquisto = new ArrayList<OrdineAcquisto>();
		for (OrdineVendita ordineVendita : ordiniVendita) {
			List<ProdottoOrdineVendita> prodottiOrdineVendita = ordineVendita.getListaProdotti();
			for (ProdottoOrdineVendita prodottoOrdineVendita : prodottiOrdineVendita) {
				Prodotto prodotto = prodottoOrdineVendita.getProdotto();
				Fornitore fornitoreSelezionato = prodotto.getFornitoreSelezionato();
				OrdineAcquisto ordineAcquisto = ordineDaStessoFornitore(ordiniAcquisto, ordineVendita, fornitoreSelezionato);
				if(ordineAcquisto != null) {
					ordineAcquisto.getListaProdotti().add(new ProdottoOrdineAcquisto(prodotto, prodottoOrdineVendita.getQuantita(), prodotto.getPrezzoAcquisto()));
				}else {
					ordineAcquisto = new OrdineAcquisto(prodottoOrdineVendita.getOrdineVendita(), fornitoreSelezionato);
					ordineAcquisto.getListaProdotti().add(new ProdottoOrdineAcquisto(prodotto, prodottoOrdineVendita.getQuantita(), prodotto.getPrezzoAcquisto()));
					ordiniAcquisto.add(ordineAcquisto);
				}
			}
			ordineVendita.setStato(StatoOrdineVendita.inoltrato);
		}
		ordineAcquistoRepository.saveAll(ordiniAcquisto);
		ordineVenditaRepository.saveAll(ordiniVendita);
	}
	
	private OrdineAcquisto ordineDaStessoFornitore(List<OrdineAcquisto> ordiniAcquisto, OrdineVendita ordineVendita, Fornitore fornitore) {
		// Verificare che ordine acquisto, ordine vendita e fornitore non siano null
		for(OrdineAcquisto ordineAcquisto: ordiniAcquisto) {
			if(ordineAcquisto.getFornitore() != null && ordineAcquisto.getFornitore().getId() == fornitore.getId())
				if(ordineAcquisto.getOrdineVendita() != null && ordineAcquisto.getOrdineVendita().getId() == ordineVendita.getId())
					return ordineAcquisto;
		}
		return null;
	}
	
	public boolean insert(OrdineVendita ordinevendita) {
		ordineVenditaRepository.save(ordinevendita);
		return true;
	}
	
	public List<OrdineVendita> getAllOrdiniVendita() {
		return this.ordineVenditaRepository.findAll();
	}

	
}
