package com.rttCom.rttCom.service;

import java.sql.Date;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rttCom.rttCom.dao.ProdottoRepository;
import com.rttCom.rttCom.dao.UtenteRepository;
import com.rttCom.rttCom.model.Fornitore;
import com.rttCom.rttCom.model.Prodotto;
import com.rttCom.rttCom.model.Utente;


@Service
public class ProdottoService {

	private ProdottoRepository prodottoRepository;

	@Autowired
	public ProdottoService(ProdottoRepository prodottoRepository) {
		this.prodottoRepository = prodottoRepository;
	}

	public List<Prodotto> getAllProdotti() {
		return this.prodottoRepository.findAll();
	}

	public boolean insert(Prodotto prodotto) {
		prodottoRepository.save(prodotto);
		return true;
	}

	public boolean updateProdotto(Prodotto prodotto, int id) {
		prodottoRepository.updateProdotto(prodotto.getEan(), prodotto.getCategory(), prodotto.getModel(),
				prodotto.getManufacturer(), prodotto.getDescription(), prodotto.getLong_description(),
				prodotto.getSell_price(), id);
		return true;
	}

	public Prodotto getProdottoById(int id) {
		Prodotto prodotto = prodottoRepository.findById(id);
		return prodotto;
	}

	public void delete(int id) {
		prodottoRepository.deleteById(id);
	}

	public List<Prodotto> search(String parameter_one, String parameter_two) {
		List<Prodotto> prodottiFiltrati = new ArrayList<Prodotto>();

		switch (parameter_one) {
		case "id":

			int id = Integer.parseInt(parameter_two);
			prodottiFiltrati.add(prodottoRepository.findById(id));
			break;

		case "ean":

			prodottiFiltrati.add(prodottoRepository.findByEan(parameter_two));
			break;

		case "category":

			prodottiFiltrati = prodottoRepository.findByCategory(parameter_two);
			break;

		case "model":

			prodottiFiltrati = prodottoRepository.findByModel(parameter_two);
			break;

		case "manufacturer":

			prodottiFiltrati = prodottoRepository.findByManufacturer(parameter_two);
			break;

		case "sellPrice":

			double price = Double.parseDouble(parameter_two);
			prodottiFiltrati = prodottoRepository.findBySellPrice(price);
			break;

		}

		return prodottiFiltrati;
	}

	public List<Prodotto> searchPriceforInterval(String priceInterval) {
		List<Prodotto> listProdotti = new ArrayList<Prodotto>();
		String[] parts = priceInterval.split("-");
		double priceMin = Double.parseDouble(parts[0]);
		double priceMax = Double.parseDouble(parts[1]);
		listProdotti = prodottoRepository.searchPriceforInterval(priceMin, priceMax);
		return listProdotti;
	}

}
