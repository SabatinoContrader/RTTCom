package main.dao;

import main.ConnectionSingleton;
import main.controller.GestoreEccezioni;
import main.model.Canale;
import main.model.Prodotto;


import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CanaleDAO {


   // private final String QUERY_ALL = "select * from canale";

    public CanaleDAO() {
    }

    public List<Canale> getAllCanali() {
        List<Canale> canali = new ArrayList<>();
        Connection connection = ConnectionSingleton.getInstance();
        try {

            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select * from canale");
            while (resultSet.next()) {
                int id_product = resultSet.getInt("id_product");
                int id_canale = resultSet.getInt("id_canale");
                String datain = resultSet.getString("data_inizio");
                String datafin = resultSet.getString("data_fine");
                int margin = resultSet.getInt("profit_margin");
                double price = resultSet.getDouble("price");
                canali.add(new Canale(id_product, id_canale, datain, datafin, margin, price));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return canali;
    }


    public Canale getProdotto(int idcanale){
        Connection c = ConnectionSingleton.getInstance();
        Canale p;
        try{
            Statement statement = c.createStatement();
            ResultSet resultSet = statement.executeQuery("select * from canale where id_canale = "+idcanale+"");
            if(resultSet.next()){
                int idprodotto = resultSet.getInt("id_product");
                int idcanale1 = resultSet.getInt("id_canale");
                String dataini = resultSet.getString("data_inizio");
                String datafine = resultSet.getString("data_fine");
                int marginepro = resultSet.getInt("profit_margin");
                double price = resultSet.getDouble("price");
                p = new Canale(idprodotto,idcanale1,dataini,datafine,marginepro,price);
                return p;
            }
        }catch (Exception e){
            System.out.println("Errore nella ricerca dei prodotti");
        }
        return null;
    }

    public List<Prodotto> search1 (String parameterOne, String parameterTwo) {
        String QUERY_SEARCH = "select * from product where "+parameterOne+"=?";
        List<Prodotto> listProdotto= new ArrayList<>();
        Connection connection  = ConnectionSingleton.getInstance();
        try {
            PreparedStatement preparedStatement= connection.prepareStatement(QUERY_SEARCH);
            preparedStatement.setString(1, parameterTwo);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id_product = resultSet.getInt("id_product");
                int ean = resultSet.getInt("ean");
                String category = resultSet.getString("category");
                String model = resultSet.getString("model");
                String manufacturer = resultSet.getString("manufacturer");
                listProdotto.add(new Prodotto(id_product, ean, category, model, manufacturer));

            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return listProdotto;
    }



}






