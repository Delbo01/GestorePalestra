package Database;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Dao_Esercizi extends Base_Dao implements Dao_Esercizi_Interface{
    public Dao_Esercizi() {
        super();
    }
    @Override
    public void createEsercizio(int idProgramma, String nome, int serie, int ripetizioni, int carico, int recupero, String note) {
        String query = "INSERT INTO \"Esercizi\" (idProgramma,nome,serie,ripetizioni,carico,recupero,note) VALUES (?,?,?,?,?,?,?)";
        try {
            PreparedStatement statement = super.connection.prepareStatement(query);
            statement.setInt(1, idProgramma);
            statement.setString(2, nome);
            statement.setInt(3, serie);
            statement.setInt(4, ripetizioni);
            statement.setInt(5, carico);
            statement.setInt(6, recupero);
            statement.setString(7, note);
            statement.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
        }

    }

    @Override
    public void deleteEsercizio(int id) {
        String query = "DELETE FROM \"Esercizi\" WHERE id=?";
        try {
            PreparedStatement statement = super.connection.prepareStatement(query);
            statement.setInt(1, id);
            statement.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
        }

    }

    @Override
    public void updateCarico(int id, int carico) {
        String query = "UPDATE \"Esercizi\" SET carico=? WHERE id=?";
        try {
            PreparedStatement statement = super.connection.prepareStatement(query);
            statement.setInt(1, carico);
            statement.setInt(2, id);
            statement.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }
}
