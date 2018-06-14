package main.service;

import main.dao.VenditaDAO;
import main.model.Fornitore;
import main.model.Vendita;

import java.util.List;

public class VenditaService {



        private VenditaDAO venditaDAO;

        public VenditaService() {
            this.venditaDAO = new VenditaDAO();
        }

    public Fornitore getProdottofornitore(int idProdotto)  {
        //return this.venditaDAO.getProdottofornitore(idProdotto);
        return null;
    }



        public boolean modificavendita(Vendita vendita, int margine, double prezzo_acquisto) {
            return this.venditaDAO.modificavendita(vendita,margine,prezzo_acquisto);
     }

}
