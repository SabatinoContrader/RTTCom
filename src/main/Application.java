package main;

public class Application {

    public static void main(String[] args) {
        //MainDispatcher.getInstance().callView("HomeSnd",null);
        //MainDispatcher.getInstance().callAction("Login", "doControl", null);
        MainDispatcher.getInstance().callAction("LoginTrader", "doControl", null); // P
    }

}
