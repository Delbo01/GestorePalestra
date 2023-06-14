package Database;
import java.sql.*;
public class Base_Dao {
    Connection connection=null;
    public Base_Dao(){
        getConnection();
    }
    public void getConnection(){
        String username="superuser";
        String password="palestra";
        String url="jdbc:postgresql://localhost/db_Palestra";
        try{
            connection= DriverManager.getConnection(url,username,password);
            if (connection!=null){
                System.out.println("Connessione al database avvenuta con successo");
            }
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
    }
}
