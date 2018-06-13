package com.virtualpairprogrammers.services;

import com.virtualpairprogrammers.dao.LoginTraderDAO;

public class LoginTraderService {

    private LoginTraderDAO loginTraderDAO;
    private static LoginTraderService reference;

    public static LoginTraderService getService(){
        if(reference == null)
            reference = new LoginTraderService();
        return reference;
    }

    public LoginTraderService () {
        this.loginTraderDAO = new LoginTraderDAO();
    }

    public boolean login (String username, String password){
        return this.loginTraderDAO.login(username, password);
    }

    public boolean doRegister(String reg_username,String reg_password){
        return this.loginTraderDAO.doInsert(reg_username,reg_password);
    }

}
