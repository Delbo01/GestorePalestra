package Database;

import Allenamento.Esercizio;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class Dao_Esercizi extends Base_Dao implements Dao_Esercizi_Interface{
    public Dao_Esercizi() {
        super();
    }
    @Override
    public void createEsercizio(int idEs, int idProgramma, String nome, int serie, int ripetizioni, int carico, int recupero, String note) {
        String query = "INSERT INTO \"Esercizi\"  VALUES (?,?,?,?,?,?,?,?)";
        try {
            PreparedStatement statement = super.connection.prepareStatement(query);
            statement.setInt(1,idEs );
            statement.setInt(2, idProgramma);
            statement.setString(3, nome);
            statement.setInt(4, serie);
            statement.setInt(5, ripetizioni);
            statement.setInt(6, carico);
            statement.setInt(7, recupero);
            statement.setString(8, note);
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

    @Override
    public int getMaxIdEsercizio() {
        String query = "SELECT MAX(id) FROM \"Esercizi\"";
        try {
            PreparedStatement statement = super.connection.prepareStatement(query);
            ResultSet rs = statement.executeQuery();
            while (rs.next()){
                return rs.getInt(1);
            }
        }catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    public Esercizio getEsercizo(int id){
        String query = "SELECT * FROM \"Esercizi\" WHERE id=?";
        try {
            PreparedStatement statement = super.connection.prepareStatement(query);
            statement.setInt(1, id);
            ResultSet rs = statement.executeQuery();
            while (rs.next()){
                Esercizio es= new Esercizio(rs.getString("nome"),rs.getInt("serie"),rs.getInt("ripetizioni"),rs.getInt("tempoRecupero"),rs.getString("note"));
                es.setCarico(rs.getInt("carico"));
                return es;
            }
        }catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    public int getId(int idProgramma, int nEs){
        String query = "SELECT id FROM \"Esercizi\" WHERE idprogramma=? And ((Select count(*) from \"Esercizi\" where idprogramma=? )=?)";
        try {
            PreparedStatement statement = super.connection.prepareStatement(query);
            statement.setInt(1, idProgramma);
            statement.setInt(2, idProgramma);
            statement.setInt(3, nEs);
            ResultSet rs = statement.executeQuery();
            while (rs.next()){
                return rs.getInt(1);
            }
        }catch (SQLException e) {
            e.printStackTrace();
        }
        return -1;
    }
}
