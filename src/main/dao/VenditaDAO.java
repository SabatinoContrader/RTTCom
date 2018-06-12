package main.dao;

import main.ConnectionSingleton;
import main.controller.GestoreEccezioni;
import main.model.Prodotto;
import main.model.Vendita;

import java.sql.*;
import main.model.Fornitore;

public class VenditaDAO {

    private final String QUERY_INSERT = "insert into vendita (id_product,id_canale,category, model, manufacturer,data_inizio, data_fine, prezzo_vendita) values (?,?,?,?,?,?,?,?)";
    private final String QUERY_PRICE = "select price from fornitori where id_product=?";


    public VenditaDAO() {

    }

    public Fornitore getProdottofornitore(int idProdotto) {
        Connection c = ConnectionSingleton.getInstance();
        Fornitore f;
        try {
            Statement statement = c.createStatement();
            ResultSet resultSet = statement.executeQuery("select * from fornitore where id_product = " + idProdotto + "");
            if (resultSet.next()) {
                int id_prodotto = resultSet.getInt("id_product");
                int id_fornitore = resultSet.getInt("id_fornitore");
                String dataini = resultSet.getString("data_inizio");

                String datafin = resultSet.getString("data_fine");
                
                double prezzoac = resultSet.getDouble("prezzo_acquisto");
                f = new Fornitore(id_prodotto, id_fornitore, dataini, datafin, prezzoac);

                return f;
            }
        } catch (SQLException e) {
            System.out.println("Errore nella ricerca dei prodotti");
        }
        return null;

    }

        public boolean modificavendita (Vendita vendita,int margine, double prezzo_acquisto){
            Connection connection = ConnectionSingleton.getInstance();
            try {

                PreparedStatement preparedStatement = connection.prepareStatement(QUERY_INSERT);
                preparedStatement.setInt(1, vendita.getId_product());
                preparedStatement.setInt(2, vendita.getId_canale());
                preparedStatement.setString(3, vendita.getCategory());
                preparedStatement.setString(4, vendita.getModel());
                preparedStatement.setString(5, vendita.getManufacturer());
                preparedStatement.setString(6, vendita.getData_inizio());
                preparedStatement.setString(7, vendita.getData_fine());
                preparedStatement.setDouble(8, vendita.getPricevendita(prezzo_acquisto, margine));
                return preparedStatement.execute();
            } catch (SQLException e) {
                GestoreEccezioni.getInstance().gestisciEccezione(e);
                return false;
            }


        }

    }
