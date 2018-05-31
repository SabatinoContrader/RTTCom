package main.service;

import main.dao.LoginTraderDAO;

public class LoginTraiderService {

    private LoginTraderDAO loginTraderDAO;

    // Costruttore della CLASSE
    public LoginTraiderService () {

        this.loginTraderDAO = new LoginTraderDAO();

    }

    // Metodo che riceve in ingresso i parametri del login
    public boolean login (String username, String password){
        return this.loginTraderDAO.login(username, password); // qui mi richiamo il metodo del file LOGINTRADERDAO
    }

}
