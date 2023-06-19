package Database;

import Allenamento.Scheda;
import Allenamento.SchedaMapper;
import Cliente.*;
import Istruttore.Istruttore;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Dao_Scheda_Cliente extends Base_Dao implements Dao_Scheda_Cliente_Interface{
    @Override
    public void createScheda_Cliente(int idC, int idS) {
        String query= "INSERT INTO \"Scheda_Cliente\"(idCliente,idScheda) VALUES(?,?)";
        try {
            PreparedStatement statement=super.connection.prepareStatement(query);
            statement.setInt(1,idC);
            statement.setInt(2,idS);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public boolean checkScheda_Cliente(int idC) {
        String query= "SELECT * FROM \"Scheda_Cliente\" WHERE idCliente=?";
        try {
            PreparedStatement statement=super.connection.prepareStatement(query);
            statement.setInt(1,idC);
            ResultSet rs=statement.executeQuery();
            return rs.next();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public void updateScheda_Cliente(int idC, int idScheda) {
        String query= "UPDATE \"Scheda_Cliente\" SET idScheda=? WHERE idCliente=?";
        try {
            PreparedStatement statement=super.connection.prepareStatement(query);
            statement.setInt(1,idScheda);
            statement.setInt(2,idC);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public SchedaMapper getScheda_Cliente(int idC) {
        String query= "select * from ((\"Scheda_Cliente\" join \"Cliente\" ON \"Cliente\".id = \"Scheda_Cliente\".\"idcliente\" )join \"Scheda\" ON \"Scheda\".id=\"Scheda_Cliente\".\"idscheda\") where idCliente=?";
        try {
            PreparedStatement statement=super.connection.prepareStatement(query);
            statement.setInt(1,idC);
            ResultSet rs=statement.executeQuery();
            if(rs.next()){
                Cliente c= new Cliente(new Generalita(rs.getString(6),rs.getString(5),rs.getString(4)),rs.getFloat("altezza"),rs.getFloat("peso"),null,null);
                Scheda s= new Dao_Scheda().getScheda(rs.getInt(2));
                return new SchedaMapper(c,s);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
