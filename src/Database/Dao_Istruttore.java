package Database;
import Cliente.Generalita;
import Istruttore.Istruttore;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

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

    public int getMaxId() {
        String query="SELECT MAX(id) FROM \"Istruttore\"";
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
    public int getIdByNomeCognome(String nome, String cognome) {
        String query="SELECT id FROM \"Istruttore\" WHERE nome=? AND cognome=?";
        try{
            PreparedStatement statement=super.connection.prepareStatement(query);
            statement.setString(1,nome);
            statement.setString(2,cognome);
            ResultSet rs=statement.executeQuery();
            rs.next();
            return rs.getInt(1);
        }catch (SQLException e){
            e.printStackTrace();
        }
        return -1;
    }

    @Override
    public void setPt(int id, boolean pt) {
        String query="UPDATE \"Istruttore\" SET pt=? WHERE id=?";
        try {
            PreparedStatement statement = super.connection.prepareStatement(query);
            statement.setBoolean(1, pt);
            statement.setInt(2, id);
            statement.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    @Override
    public ArrayList<Istruttore> getAllPT() {
        String query="SELECT * FROM \"Istruttore\" WHERE pt=true";
        try{
            PreparedStatement statement=super.connection.prepareStatement(query);
            ResultSet rs=statement.executeQuery();
            ArrayList<Istruttore> istruttori=new ArrayList<>();
            while(rs.next()){
                Generalita g=new Generalita(rs.getString("cf"),rs.getString("nome"),rs.getString("cognome"));
                istruttori.add(new Istruttore(g,null));
            }
            return istruttori;
        }catch (SQLException e){
            e.printStackTrace();
        }
        return null;
    }
}
