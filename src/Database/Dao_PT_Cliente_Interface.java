package Database;

import Istruttore.Istruttore;

public interface Dao_PT_Cliente_Interface {
    public void createPT_Cliente(int idPT, int idCliente);
    public void deletePT_Cliente(int idCliente);
    public int getIdPT(int idCliente);
}
