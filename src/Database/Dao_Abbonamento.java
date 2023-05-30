package Database;

import Abbonamento.Abbonamento;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class Dao_Abbonamento extends Base_Dao implements Dao_Abbonamento_Interface{
    public Dao_Abbonamento(){
        super();
    }

    @Override
    public void creaAbbonamento(int durata, String nome, int prezzo, boolean corsi,String dataInizio,String dataFine){
        String query="INSERT INTO \"Abbonamento\" (durata,nome,prezzo,corsi,dataInizio,dataFine) VALUES (?,?,?,?,?,?)";
        try {
            PreparedStatement st = connection.prepareStatement(query);
            st.setInt(1, durata);
            st.setString(2, nome);
            st.setInt(3, prezzo);
            st.setBoolean(4, corsi);
            st.setString(5,dataInizio);
            st.setString(6,dataFine);
            st.executeUpdate();
        }catch (Exception e){
            e.printStackTrace();
        }

    }

    @Override
    public void eliminaAbbonamento(int id) {
        String query="DELETE FROM \"Abbonamento\" WHERE id=?";
        try {
            PreparedStatement st = connection.prepareStatement(query);
            st.setInt(1, id);
            st.executeUpdate();
        }catch (Exception e){
            e.printStackTrace();
        }
    }



    @Override
    public int getIdByNomeDurata(int  durata, String nome) {
        String query="SELECT id FROM \"Abbonamento\" WHERE durata=? AND nome=?";
        try {
            PreparedStatement st = connection.prepareStatement(query);
            st.setInt(1, durata);
            st.setString(2, nome);
            ResultSet rs = st.executeQuery();
            rs.next();
            return rs.getInt("id");
        }catch (Exception e){
            e.printStackTrace();
        }
        return -1;
    }

}
