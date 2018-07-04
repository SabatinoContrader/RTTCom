package com.rttCom.service;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rttCom.dao.ProdottoRepository;
import com.rttCom.model.Canale;
import com.rttCom.model.Prodotto;
import com.rttCom.model.ProdottoCanale;

import java.sql.Date;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.rttCom.dao.UtenteRepository;
//import com.rttCom.model.Fornitore;

import com.rttCom.model.ProdottoFornitore;
import com.rttCom.model.Utente;


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

	public boolean insertAll(List<Prodotto> prodotti) {
		prodottoRepository.saveAll(prodotti);
		return true;
	}

	public boolean updateProdotto(Prodotto prodotto, int id) {
		prodottoRepository.updateProdotto(prodotto.getEan(), prodotto.getCategory(), prodotto.getModel(),
				prodotto.getManufacturer(), prodotto.getDescription(), prodotto.getLongDescription(),
				prodotto.getSellPrice(), id);
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
	
	
	
/*	
    public List<Prodotto> getProdottiDaFornitori(){
        List<Prodotto> prodotti = new LinkedList<Prodotto>();
        List<Fornitore> fornitori = FornitoreFactory.getInstance().getFornitori();
        for(int i=0;i<fornitori.size();i++){
            List<Prodotto> catalogoFornitore = fornitori.get(i).getCatalogoProdotti();
            for(int j = 0; j < catalogoFornitore.size(); j++){
                Prodotto prodottoDalFornitore = catalogoFornitore.get(j);
                ProdottoFornitore prodottoFornitore = new ProdottoFornitore(fornitori.get(i).getId(),"" + prodottoDalFornitore.getId(),1, new Date(118,0,1), null, prodottoDalFornitore.getSellPrice());
                int indiceProdotto = cercaEanProdotto(prodottoDalFornitore, prodotti);
                if(indiceProdotto >= 0){
                    prodotti.get(indiceProdotto).aggiungiAListaAcquisto(prodottoFornitore);
                }else{
                    prodottoDalFornitore.aggiungiAListaAcquisto(prodottoFornitore);
                    prodotti.add(prodottoDalFornitore);
                }
            }
        }
        return prodotti;
    }
	
    public void copiaDaFornitori(){
    	this.insertAll(getProdottiDaFornitori());
    }

    private int cercaEanProdotto(Prodotto prodotto, List<Prodotto> catalogo){
        for(int i = 0; i < catalogo.size(); i++){
            if(catalogo.get(i).getEan().equalsIgnoreCase(prodotto.getEan()))
                return i;
        }
        return -1;
    }
*/
}
