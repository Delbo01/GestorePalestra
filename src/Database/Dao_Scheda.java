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
    public void createScheda(int idIstruttore,int idScheda, String obiettivo, int numeroProgrammi) {
        String query = "INSERT INTO \"Scheda\" (idIstruttore,id,obiettivo,numeroProgrammi) VALUES (?,?,?,?)";
        try {
            PreparedStatement statement = super.connection.prepareStatement(query);
            statement.setInt(1, idIstruttore);
            statement.setInt(2, idScheda);
            statement.setString(3, obiettivo);
            statement.setInt(4, numeroProgrammi);
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
                for (int i=0;i<rs.getInt("numeroProgrammi");i++){
                    scheda.addProgramma(new Dao_Programma().getProgramma(id));
                }
                return scheda;
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return null;
    }
}

