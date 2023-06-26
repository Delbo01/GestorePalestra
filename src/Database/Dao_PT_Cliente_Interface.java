package Database;


public interface Dao_PT_Cliente_Interface {
    void createPT_Cliente(int idPT, int idCliente);
    void deletePT_Cliente(int idCliente);
    int getIdPT(int idCliente);
}
