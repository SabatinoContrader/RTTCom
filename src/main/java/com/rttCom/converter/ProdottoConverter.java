package com.rttCom.converter;

import org.springframework.stereotype.Component;

import com.rttCom.dto.ProdottoDTO;
import com.rttCom.model.Prodotto;

@Component
public class ProdottoConverter implements Converter<Prodotto, ProdottoDTO> {

	@Override
	public Prodotto convertToEntity(ProdottoDTO prodottoDTO) {
		Prodotto prodotto = new Prodotto();
		prodotto.setId(prodottoDTO.getId());
		prodotto.setEan(prodottoDTO.getEan());
		prodotto.setCategory(prodottoDTO.getCategory());
		prodotto.setModel(prodottoDTO.getModel());
		prodotto.setManufacturer(prodottoDTO.getManufacturer());
		prodotto.setDescription(prodottoDTO.getDescription());
		prodotto.setLongDescription(prodottoDTO.getLongDescription());
		prodotto.setSellPrice(prodottoDTO.getSellPrice());
		return prodotto;
	}

	@Override
	public ProdottoDTO convertToDTO(Prodotto prodotto) {
		return new ProdottoDTO(prodotto.getId(), prodotto.getEan(), prodotto.getCategory(), prodotto.getModel(),
				prodotto.getManufacturer(), prodotto.getDescription(), prodotto.getLongDescription(),
				prodotto.getSellPrice());
	}
}