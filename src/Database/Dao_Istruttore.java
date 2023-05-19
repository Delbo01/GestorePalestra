package Database;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
public class Dao_Istruttore extends Base_Dao implements Dao_Istruttore_Interface{
    public Dao_Istruttore(){
        super();
    }

    @Override
    public void createIstruttore(int id, String nome, String cognome, String codiceFiscale, boolean pt, int nAssistiti) {
        String query= "INSERT INTO \"Istruttore\" VALUES(?,?,?,?,?,?)";
        try {
            PreparedStatement statement=super.connection.prepareStatement(query);
            statement.setInt(1,id);
            statement.setString(2,nome);
            statement.setString(3,cognome);
            statement.setString(4,codiceFiscale);
            statement.setBoolean(5,pt);
            statement.setInt(6,nAssistiti);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updatePt(int id, boolean pt) {
        String query= "UPDATE \"Istruttore\" SET pt=? where id=?";
        try {
            PreparedStatement statement=super.connection.prepareStatement(query);
            statement.setBoolean(1,pt);
            statement.setInt(2,id);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void incrementaAssistiti(int id) {
        String query= "UPDATE \"Istruttore\" SET \"numeroAssistiti\"=\"numeroAssistiti\"+1 where id=?";
        try {
            PreparedStatement statement=super.connection.prepareStatement(query);
            statement.setInt(1,id);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void decrementaAssistiti(int id) {
        String query= "UPDATE \"Istruttore\" SET \"numeroAssistiti\"=\"numeroAssistiti\"-1 where id=?";
        try {
            PreparedStatement statement=super.connection.prepareStatement(query);
            statement.setInt(1,id);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
