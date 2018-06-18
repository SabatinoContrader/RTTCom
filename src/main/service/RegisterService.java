package main.service;

import main.dao.UtenteDAO;

public class RegisterService {

    private UtenteDAO utenteDAO;

    public RegisterService() {
        this.utenteDAO = new UtenteDAO();
    }


}
