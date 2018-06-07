package main.service;

import main.dao.LoginTraderDAO;

public class LoginTraiderService {

    private LoginTraderDAO loginTraderDAO;

    public LoginTraiderService () {
        this.loginTraderDAO = new LoginTraderDAO();
    }

    public boolean login (String username, String password){
        return this.loginTraderDAO.login(username, password);
    }

}
