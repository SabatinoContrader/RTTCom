package main.dao;

import main.ConnectionSingleton;
import main.controller.GestoreEccezioni;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class LoginTraderDAO {

    // mi dichiaro una costante per la successiva query
    private final String QUERY_LOGIN = "select * from users where username = ? and password = ?";

    // Metodo per il login che ti permette di scrivere la password
    public boolean login (String username, String password) {

        Connection connection  = ConnectionSingleton.getInstance();
        try{

            PreparedStatement stmt = connection.prepareStatement(QUERY_LOGIN);
            stmt.setString(1, username);
            stmt.setString(2, password);
            return stmt.executeQuery().next();

        } catch(SQLException e){
            GestoreEccezioni.getInstance().gestisciEccezione(e);
            return false;
        }

    }

}
