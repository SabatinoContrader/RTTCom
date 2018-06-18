package main.service;

import main.dao.UtenteDAO;
import main.model.Utente;

public class LoginService {

    private UtenteDAO utenteDAO;

    public LoginService() {
        this.utenteDAO = new UtenteDAO();
    }

    public boolean login (String username, String password) {
        Utente utente = utenteDAO.getByNomeUtente(username);
        if(utente == null){
            return false;
        }else{
            if(utente.getPassword().equals(password)) return true;
            else return false;
        }

    }


}
