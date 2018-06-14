package main.dao;

import main.ConnectionSingleton;
import main.controller.GestoreEccezioni;
import main.model.*;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProdottoDAO {

    private final String QUERY_ALL = "select * from product";

    private final String QUERY_INSERT = "insert into product (id_product, ean, category, model, manufacturer) values (?,?,?,?,?)";
    private final String QUERY_INSERT_PROFIT = "insert into profit (id_product,ecommerce_name,profit_margin) values (?,?,?)";
    private final String QUERY_PRODOTTO_FORNIOTRE = "SELECT id_fornitore, data_inizio, data_fine, prezzo_acquisto FROM product p right join fornitore f on p.id_product = f.id_product";
    private final String QUERY_DELETE = "delete from product (ean, category, model, manufacturer) values (?,?,?,?)";
    private final String QUERY_MODIFY = "update product set (id_product, ean, category, model, manufacturer) values) values (?,?,?,?,?,?) where id_product=?";
    private final String QUERY_REQUEST_BUY ="insert into requestbuy (idproduct, quantity, pricexelem, idtrader) values (?,?,?,?)";


    public ProdottoDAO() {

    }

    public List<ProdottoFornitore> prodottoFornitore(){
        List<ProdottoFornitore> prodottiFornitore = new ArrayList<>();
        Connection connection = ConnectionSingleton.getInstance();
        try{

            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(QUERY_PRODOTTO_FORNIOTRE);
            while (resultSet.next()) {
                int id_fornitore = resultSet.getInt("id_fornitore");
                String data_inizio = resultSet.getString("data_inizio");
                String data_fine = resultSet.getString("data_fine");
                double prezzo_acquisto = resultSet.getDouble("prezzo_acquisto");
                prodottiFornitore.add(new ProdottoFornitore(id_fornitore, data_inizio, data_fine, prezzo_acquisto));
            }
        }catch (SQLException e) {
            e.printStackTrace();
        }
        return prodottiFornitore;
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
                int id_product = resultSet.getInt("id_product");
                int ean = resultSet.getInt("ean");
                String category = resultSet.getString("category");
                String model = resultSet.getString("model");
                String manufacturer = resultSet.getString("manufacturer");
                listProdotto.add(new Prodotto(id_product, ean, category, model, manufacturer));


            }
        }
        catch (SQLException e) {
            //e.printStackTrace();
            System.out.println(".> Errore di digitazione della 1^ PAROLA CHIAVE <.");
        }
        return listProdotto;
    }

    public List<Prodotto> searchGetPrezzo (String parameterOne, String parameterTwo) {
        String QUERY_SEARCH = "select * from product where category = ? and model = ?";
        List<Prodotto> listProdotto= new ArrayList<>();
        Connection connection  = ConnectionSingleton.getInstance();
        try {
            PreparedStatement preparedStatement= connection.prepareStatement(QUERY_SEARCH);
            preparedStatement.setString(1, parameterOne);
            preparedStatement.setString(2, parameterTwo);
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
            //e.printStackTrace();
            System.out.println(".> Errore di digitazione della 1^ PAROLA CHIAVE <.");
        }
        return listProdotto;
    }



    public boolean insertRequestBuy(Acquisto acquisto){
        Connection connection = ConnectionSingleton.getInstance();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(QUERY_REQUEST_BUY);
            preparedStatement.setInt(1,acquisto.getIdproduct());
            preparedStatement.setInt(2, acquisto.getQuantity());
            preparedStatement.setDouble(3, acquisto.getPricexelem());
            preparedStatement.setString(4, acquisto.getIdTrader());
            return preparedStatement.execute();
        }
        catch (SQLException e) {
            GestoreEccezioni.getInstance().gestisciEccezione(e);
            return false;
        }
    }

    public List<Prodotto> getAllProdotti () {
        List<Prodotto> prodotti = new ArrayList<>();
        Connection connection = ConnectionSingleton.getInstance();
        try {

           Statement statement = connection.createStatement();
           ResultSet resultSet = statement.executeQuery(QUERY_ALL);
           while (resultSet.next()) {
               int id_prodotto = resultSet.getInt("id_prodotto");
               int ean = resultSet.getInt("ean");
               String category = resultSet.getString("category");

               String model = resultSet.getString("model");
               String manufacturer = resultSet.getString("manufacturer");
               prodotti.add(new Prodotto(id_prodotto, ean, category, model, manufacturer));

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
            preparedStatement.setInt(1,prodotto.getIdProduct());
            preparedStatement.setInt(2, prodotto.getEan());
            preparedStatement.setString(3, prodotto.getCategory());
            preparedStatement.setString(4, prodotto.getModel());
            preparedStatement.setString(5, prodotto.getManufacturer());
            return preparedStatement.execute();
        }
        catch (SQLException e) {
            GestoreEccezioni.getInstance().gestisciEccezione(e);
            return false;
        }

            }




    public Prodotto getProdotto(int idProdotto){
        Connection c = ConnectionSingleton.getInstance();
        Prodotto p;
        try{
            Statement statement = c.createStatement();
            ResultSet resultSet = statement.executeQuery("select * from product where bar_code = "+idProdotto+"");
            if(resultSet.next()){
                int id_prodotto = resultSet.getInt("id_prodotto");
                int ean = resultSet.getInt("ean");
                String category = resultSet.getString("category");

                String model = resultSet.getString("model");
                String manufacturer = resultSet.getString("manufacturer");
                p = new Prodotto(id_prodotto,ean,category,model,manufacturer);

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
            PreparedStatement preparedStatement = //c.prepareStatement("delete from profit where id_product="+id+"");
                    c.prepareStatement("delete from contrader.product where id_product ="+id+"");
            preparedStatement.executeUpdate();
            return preparedStatement.execute();
        }catch (SQLException e){
            GestoreEccezioni.getInstance().gestisciEccezione(e);
            return false;
        }

    }

    public boolean deleteProfit(Profit p){
        Connection c = ConnectionSingleton.getInstance();
        try{
            PreparedStatement ps = c.prepareStatement("delete from profit where id_product="+p.getId_product()+"");
            ps.executeUpdate();
            return ps.execute();
        }catch (Exception e){
            GestoreEccezioni.getInstance().gestisciEccezione(e);
            return false;
        }
    }


    public boolean modifyProdotto(Prodotto pro, int id) {
        Connection c = ConnectionSingleton.getInstance();

        try{

            PreparedStatement preparedStatement = c.prepareStatement("update product set bar_code=?, category=?, subcategory=?, model=?, manufacturer=? where bar_code="+id+"");
            preparedStatement.setInt(1, pro.getIdProduct());
            preparedStatement.setInt(2, pro.getEan());
            preparedStatement.setString(3, pro.getCategory());
            preparedStatement.setString(4, pro.getModel());
            preparedStatement.setString(5, pro.getManufacturer());


            preparedStatement.executeUpdate();
            return preparedStatement.execute();
        }
        catch (Exception e){
                System.out.println("Prodotto non presente");
            GestoreEccezioni.getInstance().gestisciEccezione(e);
            return false;
        }

    }
}
