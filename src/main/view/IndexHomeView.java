package main.view;

import main.MainDispatcher;
import main.controller.Request;

import java.util.Scanner;

public class IndexHomeView implements View{


    @Override
    public void showResults(Request request) {

    }

    @Override
    public void showOptions() {

        System.out.println("----------- MENU PRINCIPALE TRADER-----------");
        System.out.println();
        System.out.println(".: Premi [1] Registrazione ");
        System.out.println(".: Premi [2] Login ");
        System.out.print(".:> ");
        Scanner s = new Scanner(System.in);
        int v = s.nextInt();

        switch (v) {
            case 1:
                MainDispatcher.getInstance().callView("Register", null);
                break;
            case 2:
                MainDispatcher.getInstance().callAction("LoginTrader", "doControl", null);
                break;
        }

    }

    @Override
    public String getInput() {
        return null;
    }

    @Override
    public void submit() {

    }
}
