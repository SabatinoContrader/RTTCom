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

    private final String QUERY_ALL = "select * from fornitore";
    private final String QUERY_ALL_REQUEST_BUY = "select * from requestbuy";

    public ProdottoFornitoreDAO() {

    }

    public List<ProdottoFornitore> getAllProdotti () {
        List<ProdottoFornitore> prodotti = new ArrayList<>();
        Connection connection = ConnectionSingleton.getInstance();
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(QUERY_ALL);
            while (resultSet.next()) {
                int idprodotto = resultSet.getInt("idprodotto");
                int idfornitore = resultSet.getInt("idfornitore");
                String datainiziale = resultSet.getString("datainiziale");
                String datafinale = resultSet.getString("datafinale");
                double prezzoacquisto = resultSet.getDouble("prezzoacquisto");
                prodotti.add(new ProdottoFornitore(idprodotto, idfornitore, datainiziale, datafinale, prezzoacquisto));
            }
        }
        catch (SQLException e) {
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
