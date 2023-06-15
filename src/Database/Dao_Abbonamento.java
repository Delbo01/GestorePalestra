package Database;

import Abbonamento.Abbonamento;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class Dao_Abbonamento extends Base_Dao implements Dao_Abbonamento_Interface{
    public Dao_Abbonamento(){
        super();
    }

    @Override
    public void creaAbbonamento(int id, int durata, String nome, int prezzo, boolean corsi,String dataInizio,String dataFine){
        String query="INSERT INTO \"Abbonamento\" (id,durata,nome,prezzo,data_inizio,data_fine,corsi) VALUES (?,?,?,?,?,?,?)";
        try {
            PreparedStatement st = super.connection.prepareStatement(query);
            st.setInt(1, id);
            st.setInt(2, durata);
            st.setString(3, nome);
            st.setInt(4, prezzo);
            st.setString(5,dataInizio);
            st.setString(6,dataFine);
            st.setBoolean(7, corsi);
            st.executeUpdate();
        }catch (Exception e){
            e.printStackTrace();
        }

    }

    @Override
    public void eliminaAbbonamento(int id) {
        String query="DELETE FROM \"Abbonamento\" WHERE id=?";
        try {
            PreparedStatement st = super.connection.prepareStatement(query);
            st.setInt(1, id);
            st.executeUpdate();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public int getMaxId() {
        String query="SELECT MAX(id) FROM \"Abbonamento\"";
        try {
            PreparedStatement st = connection.prepareStatement(query);
            ResultSet rs = st.executeQuery();
            rs.next();
            return rs.getInt("max");
        }catch (Exception e){
            e.printStackTrace();
        }
        return -1;
    }
}
