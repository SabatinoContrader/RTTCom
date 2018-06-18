package main.service;

import main.controller.Request;
import main.dao.UtenteDAO;
import main.model.Utente;

public class RegisterService {

    private UtenteDAO utenteDAO;

    public RegisterService() {
        this.utenteDAO = new UtenteDAO();
    }

    public int insert(Utente utente) {
         return this.utenteDAO.insert(utente);

    }

}
