package main.controller;

import main.service.LoginService;

public class RegisterController implements Controller{

    private LoginService loginService;

    public RegisterController(){
        this.loginService = new LoginService();
    }


    @Override
    public void doControl(Request request) {



    }

}
