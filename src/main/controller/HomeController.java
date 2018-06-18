package main.controller;

import main.MainDispatcher;

public class HomeController implements Controller {

    public HomeController() {
    }

    public void doControl(Request request) {
        if (request != null) {
            String action = request.get("action").toString();
            if(action != null){
                if(action.equalsIgnoreCase("home"))
                    MainDispatcher.getInstance().callView("Home", request);
            }
        }
        MainDispatcher.getInstance().callView("Home", null);
    }
}
