package Database;
import Cliente.Cliente;
import Cliente.Generalita;

import java.sql.*;
public class Dao_CredenzialiCliente extends Base_Dao implements Dao_CredenzialiCliente_Interface{

    public Dao_CredenzialiCliente(){
        super();
    }

    @Override
    public void createCredenziali(String username, String passwrd, int idCliente) {
        String query="Insert into \"CredenzialiCliente\" VALUES (?,?,?)" ;
        try {
            PreparedStatement st = super.connection.prepareStatement(query);
            st.setString(1,username);
            st.setString(2,passwrd);
            st.setInt(3,idCliente);
            st.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteCredenziali(String username,String passwrd) {
        String query="DELETE from \"CredenzialiCliente\" where \"username\"=? and \"password\"=?";
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
    public Cliente search(String username, String password) {
        String query0="select \"idCliente\" from \"CredenzialiCliente\" \n" + " where \"username\"=? and \"password\"=?";
        String query1="SELECT \"Cliente\".nome,\"Cliente\".cognome,\"Cliente\".cf,\"Cliente\".altezza,\"Cliente\".peso from \"Cliente\" join \"CredenzialiCliente\" ON \"CredenzialiCliente\".\"idCliente\" = \"Cliente\".id where id=?";
        try{
            PreparedStatement statement0=super.connection.prepareStatement(query0);
            statement0.setString(1,username);
            statement0.setString(2,password);
            ResultSet rs0=statement0.executeQuery();
            if(rs0.next()) {
                int id = rs0.getInt("idCliente");
                PreparedStatement statement1 = super.connection.prepareStatement(query1);
                statement1.setInt(1, id);
                ResultSet rs1 = statement1.executeQuery();
                if (rs1.next()) {
                    String nome = rs1.getString("nome");
                    String cognome = rs1.getString("cognome");
                    String cf = rs1.getString("cf");
                    float altezza = rs1.getFloat("altezza");
                    float peso = rs1.getFloat("peso");
                    Generalita generalita = new Generalita(cf,nome, cognome);
                    return new Cliente(generalita, altezza, peso, null, null);
                }
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return null;
    }
}
