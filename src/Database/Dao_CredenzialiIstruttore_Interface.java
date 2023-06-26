package Database;

import Istruttore.Istruttore;

public interface Dao_CredenzialiIstruttore_Interface {
    void createCredenziali(String username,String passwrd,int idIstruttore);
    void deleteCredenziali(String username,String passwrd);
    Istruttore search(String username, String password);
}
