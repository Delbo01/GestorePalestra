package Database;
import java.sql.*;
public class Base_Dao {
    Connection connection=null;
    public Base_Dao(){
        getConnection();
    }
    public void getConnection(){
        String url = "jdbc:postgresql://localhost/db_Palestra";
        String user = "superuser";
        String password = "palestra";
        try {
            connection = DriverManager.getConnection(url, user, password);
            System.out.println("Connessione al database avvenuta con successo");
        } catch (SQLException e) {
            System.out.println("Errore di connessione al database");
        }
    }
}
