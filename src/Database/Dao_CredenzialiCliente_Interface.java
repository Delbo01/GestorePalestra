package Database;

import Cliente.Cliente;

public interface Dao_CredenzialiCliente_Interface {
    public void createCredenziali(String username,String passwrd,int idCliente);
    public void deleteCredenziali(String username,String passwrd);
    public Cliente search(String username,String password);
}
