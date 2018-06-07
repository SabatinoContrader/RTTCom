package main;

import java.util.Scanner;


public class Application {

    public static void main(String[] args) {
        System.out.println(".: Premi [1] Registrazione ");
        System.out.println(".: Premi [2] Login ");
        System.out.println(".: Premi [3] Fornitore ");
        Scanner s = new Scanner(System.in);
        int v = s.nextInt();

        switch (v) {
            case 1:
                MainDispatcher.getInstance().callView("Register", null);
                break;
            case 2:
                MainDispatcher.getInstance().callAction("LoginTrader", "doControl", null);
                break;
            case 3:
                MainDispatcher.getInstance().callView("HomeFornitore",  null);

        }
    }

}
