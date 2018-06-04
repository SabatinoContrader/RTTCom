package main.service;

import main.dao.ProdottoDAO;
import main.model.Prodotto;

import java.util.List;

public class FilterOptRawMatService {

    private ProdottoDAO prodottoDAO;

    public FilterOptRawMatService() {
        this.prodottoDAO = new ProdottoDAO();
    }

    public List<Prodotto> search (String parameterOne, String parameterTwo) {
        return this.prodottoDAO.search(parameterOne, parameterTwo);
    }

}
