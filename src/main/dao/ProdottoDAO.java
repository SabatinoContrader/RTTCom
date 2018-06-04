package main.dao;

import main.ConnectionSingleton;
import main.controller.GestoreEccezioni;
import main.model.Prodotto;
import main.model.Profit;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProdottoDAO {

    private final String QUERY_ALL = "select * from product";
    private final String QUERY_INSERT = "insert into product (bar_code,category, subcategory, model, manufacturer, price) values (?,?,?,?,?,?)";
    private final String QUERY_INSERT_PROFIT = "insert into profit (id_product,ecommerce_name,profit_margin) values (?,?,?)";
    private final String QUERY_DELETE = "delete from product (category, subcategory, model, manufacturer, price) values (?,?,?,?,?)";

    public ProdottoDAO() {

    }

    public List<Prodotto> search (String parameterOne, String parameterTwo) {
        String QUERY_SEARCH = "select * from product where "+parameterOne+"=?";

        List<Prodotto> listProdotto= new ArrayList<>();
        Connection connection  = ConnectionSingleton.getInstance();
        try {
            PreparedStatement preparedStatement= connection.prepareStatement(QUERY_SEARCH);
            preparedStatement.setString(1, parameterTwo);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int bar_code = resultSet.getInt("bar_code");
                String category = resultSet.getString("category");
                String product = resultSet.getString("subcategory");
                String model = resultSet.getString("model");
                String manufacturer = resultSet.getString("manufacturer");
                double price = resultSet.getDouble("price");
                listProdotto.add(new Prodotto(bar_code, category, product, model, manufacturer, price));

            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return listProdotto;
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
            preparedStatement.setString(3, prodotto.getSubcategory());
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

    public Prodotto getProdotto(int barCode){
        Connection c = ConnectionSingleton.getInstance();
        Prodotto p;
        try{
            Statement statement = c.createStatement();
            ResultSet resultSet = statement.executeQuery("select * from product where bar_code = "+barCode+"");
            if(resultSet.next()){
                int bar_code = resultSet.getInt("bar_code");
                String category = resultSet.getString("category");
                String subcategory = resultSet.getString("subcategory");
                String model = resultSet.getString("model");
                String manufacturer = resultSet.getString("manufacturer");
                double price = resultSet.getDouble("price");
                p = new Prodotto(bar_code,category,subcategory,model,manufacturer,price);
                return p;
            }
        }catch (Exception e){
            System.out.println("Errore nella ricerca dei prodotti");
        }
        return null;
    }

    public boolean insertMargin(Profit profit){
        Connection c = ConnectionSingleton.getInstance();
        try{
            PreparedStatement preparedStatement = c.prepareStatement(QUERY_INSERT_PROFIT);
            preparedStatement.setInt(1,profit.getId_product());
            preparedStatement.setString(2,profit.getEcommerce_name());
            preparedStatement.setInt(3,profit.getMargin_profit());
            return preparedStatement.execute();
        }catch(Exception e){
            GestoreEccezioni.getInstance().gestisciEccezione(e);
            return true;
        }
    }

    public boolean deleteProdotto(int id) {
        Connection c = ConnectionSingleton.getInstance();
        try{
            PreparedStatement preparedStatement = c.prepareStatement("delete from profit where id_product="+id+"");
                    c.prepareStatement("delete from contrader.product where bar_code ="+id+"");
            preparedStatement.executeUpdate();
            return preparedStatement.execute();
        }catch (SQLException e){
            GestoreEccezioni.getInstance().gestisciEccezione(e);
            return false;
        }

    }

}
