package Database;
import Allenamento.Scheda;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class Dao_Scheda extends Base_Dao implements Dao_Scheda_Interface{
    public Dao_Scheda() {
        super();
    }
    @Override
    public void createScheda(int idIstruttore,int idScheda, String obiettivo, int numeroProgrammi) {
        String query = "INSERT INTO \"Scheda\"  VALUES (?,?,?,?)";
        try {
            PreparedStatement statement = super.connection.prepareStatement(query);
            statement.setInt(1, idIstruttore);
            statement.setInt(2, idScheda);
            statement.setInt(3, numeroProgrammi);
            statement.setString(4, obiettivo);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public int getMaxIdScheda() {
        String query = "SELECT MAX(id) FROM \"Scheda\"";
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
    public Scheda getScheda(int id){
        String query="select * from \"Scheda\" where id=?";
        try{
            PreparedStatement statement=super.connection.prepareStatement(query);
            statement.setInt(1,id);
            ResultSet rs=statement.executeQuery();
            if (rs.next()){
                Scheda scheda=new Scheda(rs.getString("istruttore"),rs.getString("obbiettivo"));
                ArrayList<Integer>ids= new Dao_Programma().getIdbyIdScheda(id);
                for (int i=0;i<rs.getInt("nr_programmi");i++){
                    scheda.addProgramma(new Dao_Programma().getProgramma(ids.get(i)));
                }
                return scheda;
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void deleteScheda(int id) {
        String query = "DELETE FROM \"Scheda\" WHERE id = (?)";
        try{
            PreparedStatement statement=super.connection.prepareStatement(query);
            statement.setInt(1,id);
            statement.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }
}

