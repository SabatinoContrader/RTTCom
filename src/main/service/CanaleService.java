package main.service;


import main.model.Canale;
import main.dao.CanaleDAO;
import main.model.Prodotto;


import java.util.List;



public class CanaleService {


    private CanaleDAO canaleDAO;

    public CanaleService() {
        this.canaleDAO = new CanaleDAO();
    }


    public List<Canale> getAllCanali() {
        return this.canaleDAO.getAllCanali();
    }

    public Canale getProdotto(int idcanale) { return this.canaleDAO.getProdotto(idcanale); }


    public List<Prodotto> search1 (String parameterOne, String parameterTwo) {
        return this.canaleDAO.search1(parameterOne, parameterTwo);
    }


}




