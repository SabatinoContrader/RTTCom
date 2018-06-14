package main.controller;

import main.MainDispatcher;

public class LoginTraderController implements Controller {

    public LoginTraderController() {
    }

    @Override
    public void doControl(Request request) {
        MainDispatcher.getInstance().callView("LoginTrader", request);
    }

}
