package main.controller;


import main.MainDispatcher;
import main.model.Utente;
import main.service.RegisterService;

public class RegisterController implements Controller{

    private RegisterService registerService;

    public RegisterController(){
        this.registerService = new RegisterService();
    }


    @Override
    public void doControl(Request request) {
            Utente registrazione = (Utente) request.get("registrazione");
            int id = registerService.insert(registrazione);
            request.put("id",id);
            MainDispatcher.getInstance().callView("Register", request);

    }

}
