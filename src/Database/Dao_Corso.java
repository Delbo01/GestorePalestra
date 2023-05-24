package Database;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Dao_Corso extends Base_Dao implements Dao_Corso_Interface{

    public Dao_Corso(){
        super();
    }
    @Override
    public void createCorso(int id,String nome, int posti, String orarioInizio, String orarioFine, int idIstruttore, int numeroPrenotazioni, int mese, int giorno) {
        String query = "INSERT INTO \"Corso\" (id,nome,posti,istruttore,numero_prenotazioni,mese,giorno,oraInizio,oraFine) VALUES(?,?,?,?,?,?,?,?,?)";
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
    public void vediCorsiGiornalieri(int mese, int giorno) {
        String query = "SELECT * FROM \"Corso\" WHERE  mese = ? AND giorno = ?";
        try {
            PreparedStatement statement = super.connection.prepareStatement(query);
            statement.setInt(1,mese);
            statement.setInt(2,giorno);

            statement.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
        }
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
}
