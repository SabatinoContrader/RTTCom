package main.dao;


import main.ConnectionSingleton;
import main.model.Acquisto;
import main.model.Prodotto;
import main.model.ProdottoFornitore;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ProdottoFornitoreDAO {

    private final String QUERY_ALL_FORNITORY = "select * from product";
    private final String QUERY_ALL_REQUEST_BUY = "select * from requestbuy";

    public ProdottoFornitoreDAO() {

    }

    /*public List<ProdottoFornitore> getAllProdotti () {
        List<ProdottoFornitore> prodotti = new ArrayList<>();
        Connection connection = ConnectionSingleton.getInstance();
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(QUERY_ALL);
            while (resultSet.next()) {
                int id_product = resultSet.getInt("id_product");
                int id_fornitore = resultSet.getInt("id_fornitore");
                String data_inizio = resultSet.getString("data_inizio");
                String data_fine = resultSet.getString("data_fine");
                double price = resultSet.getDouble("price");
                prodotti.add(new ProdottoFornitore(id_product, id_fornitore, data_inizio, data_fine, price));
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return prodotti;
    }*/

    public List<Prodotto> getAllProdotti () {
        List<Prodotto> prodotti = new ArrayList<>();
        Connection connection = ConnectionSingleton.getInstance();
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(QUERY_ALL_FORNITORY);
            while (resultSet.next()) {
                int id_product = resultSet.getInt("id_product");
                int ean = resultSet.getInt("ean");
                String category = resultSet.getString("category");
                String model = resultSet.getString("model");
                String manufacturer = resultSet.getString("manufacturer");
                prodotti.add(new Prodotto(id_product, ean, category, model, manufacturer));

            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return prodotti;
    }

    public List<Acquisto> getAllRequestBuy () {
        List<Acquisto> listrequest = new ArrayList<>();
        Connection connection = ConnectionSingleton.getInstance();
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(QUERY_ALL_REQUEST_BUY);
            while (resultSet.next()) {
                int idproduct = resultSet.getInt("idproduct");
                int quantity = resultSet.getInt("quantity");
                double pricexelem = resultSet.getDouble("pricexelem");
                String idtrader = resultSet.getString("idtrader");
                listrequest.add(new Acquisto(idproduct, quantity, pricexelem, idtrader));
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return listrequest;
    }

}
