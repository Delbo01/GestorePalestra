package Database;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Dao_Programma extends Base_Dao implements Dao_Programma_Interface{

    public Dao_Programma() {
        super();
    }
    @Override
    public void creaProgramma(int idScheda, int nrEsercizio, String durata) {
        String query = "INSERT INTO \"Programma\" (idScheda,nrEsercizio,durata) VALUES (?,?,?)";
        try {
            PreparedStatement statement = super.connection.prepareStatement(query);
            statement.setInt(1, idScheda);
            statement.setInt(2, nrEsercizio);
            statement.setString(3, durata);
            statement.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    @Override
    public void eliminaProgramma(int id) {
        String query = "DELETE FROM \"Programma\" WHERE id=?";
        try {
            PreparedStatement statement = super.connection.prepareStatement(query);
            statement.setInt(1, id);
            statement.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }
}
