package main.controller;

import main.MainDispatcher;
import main.service.RegisterService;

public class RegisterController implements Controller{

    private RegisterService registerService;

    public RegisterController(){
        this.registerService = new RegisterService();
    }

    @Override
    public void doControl(Request request) {
        if(request!=null){
            String nomeUtente = request.get("nomeUtente").toString();
            String password = request.get("passwordUtente").toString();
            request.put("response",this.registerService.doRegister(nomeUtente,password));
            MainDispatcher.getInstance().callView("Register",request);
        }
        else {
            System.out.println("Error");
        }
    }
}
