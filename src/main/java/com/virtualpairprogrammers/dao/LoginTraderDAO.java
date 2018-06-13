package com.virtualpairprogrammers.dao;

import com.virtualpairprogrammers.utils.ConnectionSingleton;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class LoginTraderDAO {

    // mi dichiaro una costante per la successiva query
    private final String QUERY_LOGIN = "select * from users where username = ? and pswd = ?";
    private final String QUERY_REGISTER = "insert into users(username,pswd) values(?,?)";

    // Metodo per il login che ti permette di scrivere la password
    public boolean login (String username, String password) {

        Connection connection  = ConnectionSingleton.getInstance();
        try{

            PreparedStatement stmt = connection.prepareStatement(QUERY_LOGIN);
            stmt.setString(1, username);
            stmt.setString(2, password);
            return stmt.executeQuery().next();

        } catch(SQLException e){
          //  GestoreEccezioni.getInstance().gestisciEccezione(e);
            return false;
        }

    }

    public boolean doInsert(String username,String password) {

        Connection c = ConnectionSingleton.getInstance();
        try {
            PreparedStatement statement = c.prepareStatement(QUERY_REGISTER);
            statement.setString(1, username);
            statement.setString(2, password);
            statement.executeUpdate();
            return true;
        } catch (Exception e) {
            //GestoreEccezioni.getInstance().gestisciEccezione(e);
            return false;
        }

    }
}
