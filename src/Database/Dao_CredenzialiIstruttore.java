package Database;

import Cliente.Generalita;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import Istruttore.Istruttore;

public class Dao_CredenzialiIstruttore extends Base_Dao implements Dao_CredenzialiIstruttore_Interface{

    public Dao_CredenzialiIstruttore(){
        super();
    }
    @Override
    public void createCredenziali(String username, String passwrd, int idIstruttore) {
        String query="Insert into \"CredenzialiIstruttore\" VALUES (?,?,?)" ;
        try {
            PreparedStatement st = super.connection.prepareStatement(query);
            st.setString(1,username);
            st.setString(2,passwrd);
            st.setInt(3,idIstruttore);
            st.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteCredenziali(String username, String passwrd) {
        String query="DELETE from \"CredenzialiIstruttore\" where \"username\"=? and \"password\"=?";
        try{
            PreparedStatement statement=super.connection.prepareStatement(query);
            statement.setString(1,username);
            statement.setString(2,passwrd);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Istruttore search(String username, String password) {
        String query0="select \"idIstruttore\" from \"CredenzialiIstruttore\" \n" + " where \"username\"=? and \"password\"=?";
        String query1="SELECT \"Istruttore\".nome,\"Istruttore\".cognome,\"Istruttore\".cf,\"Istruttore\".pt from \"Istruttore\" join \"CredenzialiIstruttore\" ON \"CredenzialiIstruttore\".\"idIstruttore\" = \"Istruttore\".id where id=?";
        try{
            PreparedStatement statement0=super.connection.prepareStatement(query0);
            statement0.setString(1,username);
            statement0.setString(2,password);
            ResultSet rs0=statement0.executeQuery();
            if(rs0.next()) {
                int id = rs0.getInt("idIstruttore");
                PreparedStatement statement1 = super.connection.prepareStatement(query1);
                statement1.setInt(1, id);
                ResultSet rs1 = statement1.executeQuery();
                if (rs1.next()) {
                    String nome = rs1.getString("nome");
                    String cognome = rs1.getString("cognome");
                    String cf = rs1.getString("cf");
                    Generalita generalita = new Generalita(nome, cognome, cf);
                    return new Istruttore(generalita,null,null);
                }
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return null;
    }
}
