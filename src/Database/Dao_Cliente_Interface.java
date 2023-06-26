package Database;

public interface Dao_Cliente_Interface {
    void createCliente(int id, String nome, String cognome,String cf, float altezza, float peso);
    int getMaxId();
    int getIdByCf(String cf);
    void deleteCliente(int id);
}
