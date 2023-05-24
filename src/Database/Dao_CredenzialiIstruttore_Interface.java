package Database;

import Istruttore.Istruttore;

public interface Dao_CredenzialiIstruttore_Interface {
    public void createCredenziali(String username,String passwrd,int idIstruttore);
    public void deleteCredenziali(String username,String passwrd);
    public Istruttore search(String username, String password);
}
