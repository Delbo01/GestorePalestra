package Database;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class Dao_Cliente extends Base_Dao implements Dao_Cliente_Interface{

    public Dao_Cliente(){
        super();
    }

    @Override
    public void createCliente(int id, String nome, String cognome,String cf,float altezza, float peso) {
        String query="INSERT INTO \"Cliente\" (id,nome,cognome,cf,altezza,peso) VALUES (?,?,?,?,?,?)";
        try{
            PreparedStatement statement=super.connection.prepareStatement(query);
            statement.setInt(1, id);
            statement.setString(2, nome);
            statement.setString(3, cognome);
            statement.setString(4, cf);
            statement.setFloat(5, altezza);
            statement.setFloat(6, peso);

            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public int getMaxId() {
        String query="SELECT MAX(id) FROM \"Cliente\"";
        try{
            PreparedStatement statement=super.connection.prepareStatement(query);
            ResultSet rs=statement.executeQuery();
            rs.next();
            return rs.getInt(1);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return -1;
    }

    @Override
    public int getIdByCf(String cf) {
        String query="SELECT id FROM \"Cliente\" WHERE cf=?";
        try{
            PreparedStatement statement=super.connection.prepareStatement(query);
            statement.setString(1, cf);
            ResultSet rs=statement.executeQuery();
            rs.next();
            return rs.getInt(1);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return -1;
    }
}
