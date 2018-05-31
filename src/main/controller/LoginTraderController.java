package main.controller;

import main.MainDispatcher;

public class LoginTraderController implements Controller {


    // Quando implemento un controller devo sempre fare un OVERRIDE
    //@Override
    public void doControl(Request request) {
        MainDispatcher.getInstance().callView("LoginTrader", request); //<-- qui aggiungo l'intestazione del nuovo file LOGINVISTA CHE ho creato
    }

}
