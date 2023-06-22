package Database;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Dao_PT_Cliente extends Base_Dao implements Dao_PT_Cliente_Interface{
    public Dao_PT_Cliente() {
        super();
    }

    @Override
    public void createPT_Cliente(int idPT, int idCliente) {
        String query="INSERT INTO \"PT_Cliente\" (idc,idi) VALUES (?,?)";
        try {
            PreparedStatement statement=super.connection.prepareStatement(query);
            statement.setInt(1, idCliente);
            statement.setInt(2, idPT);

            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deletePT_Cliente(int idCliente) {
        String query="DELETE FROM \"PT_Cliente\" WHERE idc=?";
        try {
            PreparedStatement statement=super.connection.prepareStatement(query);
            statement.setInt(1, idCliente);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public int getIdPT(int idCliente) {
        String query="SELECT idi FROM \"PT_Cliente\" WHERE idc=?";
        try {
            PreparedStatement statement=super.connection.prepareStatement(query);
            statement.setInt(1, idCliente);
            ResultSet rs=statement.executeQuery();
            if (rs.next())
                return rs.getInt("idI");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return -1;
    }
}
