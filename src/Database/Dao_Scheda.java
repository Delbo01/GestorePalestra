package Database;
import Allenamento.Scheda;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Dao_Scheda extends Base_Dao implements Dao_Scheda_Interface{
    public Dao_Scheda() {
        super();
    }
    @Override
    public void createScheda(int idIstruttore, String obiettivo, int numeroProgrammi) {
        String query = "INSERT INTO \"Scheda\" (idIstruttore,obiettivo,numeroProgrammi) VALUES (?,?,?)";
        try {
            PreparedStatement statement = super.connection.prepareStatement(query);
            statement.setInt(1, idIstruttore);
            statement.setString(2, obiettivo);
            statement.setInt(3, numeroProgrammi);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    @Override
    public void vediScheda(int idS) {
        String query = "SELECT * FROM \"Scheda\" WHERE idS=?";
        try {
            PreparedStatement statement = super.connection.prepareStatement(query);
            statement.setInt(1, idS);
            ResultSet rs = statement.executeQuery();
            while (rs.next()){
                System.out.println("idS: "+rs.getInt("idS"));
                System.out.println("idIstruttore: "+rs.getInt("idIstruttore"));
                System.out.println("obiettivo: "+rs.getString("obiettivo"));
                System.out.println("numeroProgrammi: "+rs.getInt("numeroProgrammi"));
            }
        }catch (SQLException e) {
            e.printStackTrace();
        }
    }

}

