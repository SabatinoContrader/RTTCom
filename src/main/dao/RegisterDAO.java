package main.dao;

import main.ConnectionSingleton;
import main.controller.GestoreEccezioni;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class RegisterDAO {

    private final String QUERY_LOGIN = "insert into users(username,password) values(?,?)";


    public boolean doInsert(String username,String password){

        Connection c = ConnectionSingleton.getInstance();
        try{
            PreparedStatement statement = c.prepareStatement(this.QUERY_LOGIN);
            statement.setString(1,username);
            statement.setString(2,password);
            statement.executeUpdate();
            return true;
        }catch (Exception e){
            GestoreEccezioni.getInstance().gestisciEccezione(e);
            return false;
        }

    }


}
