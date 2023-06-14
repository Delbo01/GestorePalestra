package Database;

import Abbonamento.Abbonamento;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;

public class Dao_Abbonamento_Cliente extends Base_Dao implements Dao_Abbonamento_Cliente_Interface{
    public Dao_Abbonamento_Cliente() {
        super();
    }

    @Override
    public void creaAbbonamentoCliente(int idCliente, int idAbbonamento) {
        String query="INSERT INTO \"Abbonamento_Cliente\" (idCliente,idAbbonamento) VALUES (?,?)";
        try{
            PreparedStatement statement=super.connection.prepareStatement(query);
            statement.setInt(1, idCliente);
            statement.setInt(2, idAbbonamento);

            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void eliminaAbbonamentoCliente(int idCliente, int idAbbonamento) {
        String query="DELETE FROM \"Abbonamento_Cliente\" WHERE idCliente=? AND idAbbonamento=?";
        try{
            PreparedStatement statement=super.connection.prepareStatement(query);
            statement.setInt(1, idCliente);
            statement.setInt(2, idAbbonamento);

            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Abbonamento getAbbonamento(int idCliente) {
        String query="SELECT * FROM \"Abbonamento\" WHERE id=(SELECT \"idAbbonamento\" FROM \"Abbonamento_Cliente\" WHERE \"idCliente\"=?)";
        try{
            PreparedStatement statement=super.connection.prepareStatement(query);
            statement.setInt(1, idCliente);
            ResultSet rs=statement.executeQuery();
            while (rs.next()){
                int duarata=rs.getInt("durata");
                String nome=rs.getString("nome");
                int prezzo=rs.getInt("prezzo");
                String dataInizio=rs.getString("dataInizio");
                String dataFine=rs.getString("dataFine");
                boolean corsi=rs.getBoolean("corsi");
                return new Abbonamento(duarata,nome,prezzo,dataInizio,corsi);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
