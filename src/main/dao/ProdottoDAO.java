package main.dao;

import main.ConnectionSingleton;
import main.controller.GestoreEccezioni;
import main.model.Prodotto;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProdottoDAO {

    private final String QUERY_ALL = "select * from product";
    private final String QUERY_INSERT = "insert into product (bar_code,category, subcategory, model, manufacturer, price) values (?,?,?,?,?,?)";

    public ProdottoDAO() {

    }

    public List<Prodotto> getAllProdotti () {
        List<Prodotto> prodotti = new ArrayList<>();
        Connection connection = ConnectionSingleton.getInstance();
        try {

           Statement statement = connection.createStatement();
           ResultSet resultSet = statement.executeQuery(QUERY_ALL);
           while (resultSet.next()) {
               int bar_code = resultSet.getInt("bar_code");
               String category = resultSet.getString("category");
               String product = resultSet.getString("subcategory");
               String model = resultSet.getString("model");
               String manufacturer = resultSet.getString("manufacturer");
               double price = resultSet.getDouble("price");
               prodotti.add(new Prodotto(bar_code,category, product, model, manufacturer, price));
           }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return prodotti;
    }

    public boolean insertProdotto(Prodotto prodotto) {
        Connection connection = ConnectionSingleton.getInstance();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(QUERY_INSERT);
            preparedStatement.setInt(1,prodotto.getBarCode());
            preparedStatement.setString(2, prodotto.getCategory());
            preparedStatement.setString(3, prodotto.getProduct());
            preparedStatement.setString(4, prodotto.getModel());
            preparedStatement.setString(5, prodotto.getManufacturer());
            preparedStatement.setDouble(6, prodotto.getPrice());
            return preparedStatement.execute();
        }
        catch (SQLException e) {
            GestoreEccezioni.getInstance().gestisciEccezione(e);
            return false;
        }

    }


}
