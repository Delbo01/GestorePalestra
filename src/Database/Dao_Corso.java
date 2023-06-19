package Database;

import Calendario.Corso;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class Dao_Corso extends Base_Dao implements Dao_Corso_Interface{

    public Dao_Corso(){
        super();
    }
    @Override
    public void createCorso(int id,String nome, int posti, String orarioInizio, String orarioFine, int idIstruttore, int numeroPrenotazioni, int mese, int giorno) {
        String query = "INSERT INTO \"Corso\"  VALUES(?,?,?,?,?,?,?,?,?)";
        try{
            PreparedStatement statement=super.connection.prepareStatement(query);
            statement.setInt(1, id);
            statement.setString(2,nome);
            statement.setInt(3,posti);
            statement.setInt(4,idIstruttore);
            statement.setInt(5,numeroPrenotazioni);
            statement.setInt(6,mese);
            statement.setInt(7,giorno);
            statement.setString(8,orarioInizio);
            statement.setString(9,orarioFine);

            statement.executeUpdate();

        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    @Override
    public void removeCorso(int id) {
        String query = "DELETE FROM \"Corso\" WHERE id = (?)";

        try {
            PreparedStatement statement=super.connection.prepareStatement(query);
            statement.setInt(1,id);

            statement.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
        }

    }

    @Override
    public ArrayList<Corso> vediCorsiGiornalieri(int mese, int giorno) {
        ArrayList<Corso> corsi=new ArrayList<>();
        String query = "SELECT * FROM \"Corso\" join \"Istruttore\" on \"Corso\".istruttore=\"Istruttore\".id WHERE  mese = ? AND giorno = ?";
        try {
            PreparedStatement statement = super.connection.prepareStatement(query);
            statement.setInt(1,mese);
            statement.setInt(2,giorno);
            ResultSet rs = statement.executeQuery();
            while(rs.next()){
                Corso corso=new Corso(rs.getString("nome"),rs.getInt("posti"),rs.getString("oraInizio"),rs.getString("oraFine"),rs.getString(11), rs.getString(12));
                corsi.add(corso);
            }
            return corsi;
        }catch (SQLException e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public ArrayList<Corso> vediCorsiMensili(int mese) {
        ArrayList<Corso> corsi=new ArrayList<>();
        String query = "SELECT * FROM \"Corso\" join \"Istruttore\" on \"Corso\".istruttore=\"Istruttore\".id WHERE  mese = ? ";
        try {
            PreparedStatement statement = super.connection.prepareStatement(query);
            statement.setInt(1,mese);
            ResultSet rs = statement.executeQuery();
            while(rs.next()){
                Corso corso=new Corso(rs.getString("nome"),rs.getInt("posti"),rs.getString("oraInizio"),rs.getString("oraFine"),rs.getString(11), rs.getString(12));
                corsi.add(corso);
            }
            return corsi;
        }catch (SQLException e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void addPrenotazione(int idCorso) {
        String query = "UPDATE \"Corso\" SET numero_prenotazioni = numero_prenotazioni + 1 WHERE id = ?";
        try {
            PreparedStatement statement = super.connection.prepareStatement(query);
            statement.setInt(1,idCorso);

            statement.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
        }

    }

    public void deletePrenotazione(int idCorso){
        String query = "UPDATE \"Corso\" SET numero_prenotazioni = numero_prenotazioni - 1 WHERE id = ?";
        try {
            PreparedStatement statement = super.connection.prepareStatement(query);
            statement.setInt(1,idCorso);

            statement.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    @Override
    public int getNumeroPrenotazioni(int idCorso) {
        String query="SELECT numero_prenotazioni FROM \"Corso\" WHERE id = ?";
        try{
            PreparedStatement statement=super.connection.prepareStatement(query);
            statement.setInt(1,idCorso);
            ResultSet rs=statement.executeQuery();
            rs.next();
            return rs.getInt(1);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return -1;
    }

    @Override
    public int getMaxId() {
        String query="SELECT MAX(id) FROM \"Corso\"";
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
    public int getIdByNome(String nome, int mese, int giorno) {
        String query="SELECT id FROM \"Corso\" WHERE nome = ? AND mese = ? AND giorno = ?";
        try {
            PreparedStatement statement= super.connection.prepareStatement(query);
            statement.setString(1,nome);
            statement.setInt(2,mese);
            statement.setInt(3,giorno);
            ResultSet rs=statement.executeQuery();
            rs.next();
            return rs.getInt(1);
        }catch (SQLException e){
            e.printStackTrace();
        }
        return -1;
    }
}
