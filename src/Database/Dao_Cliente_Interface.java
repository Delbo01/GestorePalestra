package Database;

public interface Dao_Cliente_Interface {
    public void createCliente(int id, String nome, String cognome,String cf, float altezza, float peso);
    public int getMaxId();
}
