package main.controller;

import main.MainDispatcher;
import main.service.LoginService;

public class LoginController implements Controller {

    private LoginService loginService;

    public LoginController() {
        loginService = new LoginService();
    }

    @Override
    public void doControl(Request request)
    {
        if (request != null) {
            String nomeUtente = request.get("nomeUtente").toString();
            String password = request.get("password").toString();
            if (loginService.login(nomeUtente, password))
                MainDispatcher.getInstance().callView("Home", request);
            else
                MainDispatcher.getInstance().callView("Login", null);
        }
        else MainDispatcher.getInstance().callView("Home", null);
    }

}
