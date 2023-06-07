package Database;

import Allenamento.ProgrammaAllenamento;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Dao_Programma extends Base_Dao implements Dao_Programma_Interface{

    public Dao_Programma() {
        super();
    }
    @Override
    public void creaProgramma(int idProg, int idScheda, int nrEsercizio, String durata) {
        String query = "INSERT INTO \"Programma\" (id,idScheda,nrEsercizio,durata) VALUES (?,?,?,?)";
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

    @Override
    public int getMaxIdProgramma() {
        String query = "SELECT MAX(id) FROM \"Programma\"";
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

    public ProgrammaAllenamento getProgramma(int id){
        String query="Select * from \"Programma\" join \"Esercizi\" ON \"Esercizi\".\"idProgramma\" = \"Programma\".id where \"Programma\".id=?";
        try{
            PreparedStatement statement= super.connection.prepareStatement(query);
            statement.setInt(1,id);
            ResultSet rs=statement.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
