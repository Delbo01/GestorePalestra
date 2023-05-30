package Database;

import java.sql.PreparedStatement;
import java.sql.SQLException;

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
}
