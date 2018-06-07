package main.controller;

import main.MainDispatcher;

public class FornitoreController implements Controller{

    @Override
    public void doControl(Request request) {

        int choice = (int) request.get("choice");

        switch (choice) {
            case 1:
                request.put("mode", "all");
                break;
            case 2:
                request.put("mode", "all_request_buy");
                break;
        }
        MainDispatcher.getInstance().callView("Fornitore", request);

    }

}
