package main.service;

import main.dao.RegisterDAO;

public class RegisterService {

    private RegisterDAO registerDao;

    public RegisterService(){
        this.registerDao = new RegisterDAO();
    }

    public boolean doRegister(String username,String password){
        return this.registerDao.doInsert(username,password);
    }

}
