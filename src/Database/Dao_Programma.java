package Database;

import Allenamento.Esercizio;
import Allenamento.ProgrammaAllenamento;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class Dao_Programma extends Base_Dao implements Dao_Programma_Interface{

    public Dao_Programma() {
        super();
    }
    @Override
    public void creaProgramma(int idProg, int idScheda, int nrEsercizio, String durata) {
        String query = "INSERT INTO \"Programma\" VALUES (?,?,?,?)";
        try {
            PreparedStatement statement = super.connection.prepareStatement(query);
            statement.setInt(1, idProg);
            statement.setInt(2, idScheda);
            statement.setInt(3, nrEsercizio);
            statement.setString(4, durata);
            statement.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    @Override
    public void deleteProgramma(int id) {
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
        String query="Select \"Esercizi\".\"id\" from \"Programma\" join \"Esercizi\" ON \"Esercizi\".\"idprogramma\" = \"Programma\".\"id\" where \"Programma\".\"id\"=?";
        try{
            PreparedStatement statement= super.connection.prepareStatement(query);
            statement.setInt(1,id);
            ResultSet rs=statement.executeQuery();
            ProgrammaAllenamento pa=new ProgrammaAllenamento(getDurata(id));
            while(rs.next()){
                Esercizio es= new Dao_Esercizi().getEsercizo(rs.getInt("id"));
                pa.addEsercizio(es);
            }
            return pa;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    String getDurata(int id){
        String query="Select \"durata\" from \"Programma\" where \"id\"=?";
        try{
            PreparedStatement statement= super.connection.prepareStatement(query);
            statement.setInt(1,id);
            ResultSet rs=statement.executeQuery();
            while(rs.next()){
                return rs.getString("durata");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return "";
    }

    public ArrayList<Integer> getIdbyIdScheda(int idScheda){
        String query="Select \"id\" from \"Programma\" where \"idScheda\"=?";
        try{
            PreparedStatement statement= super.connection.prepareStatement(query);
            statement.setInt(1,idScheda);
            ResultSet rs=statement.executeQuery();
            ArrayList<Integer> id=new ArrayList<>();
            while(rs.next()){
                id.add(rs.getInt("id"));
            }
            return id;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
