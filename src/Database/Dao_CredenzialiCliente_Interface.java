package Database;

import Cliente.Cliente;

public interface Dao_CredenzialiCliente_Interface {
    void createCredenziali(String username,String passwrd,int idCliente);
    void deleteCredenziali(String username,String passwrd);
    Cliente search(String username,String password);
}
