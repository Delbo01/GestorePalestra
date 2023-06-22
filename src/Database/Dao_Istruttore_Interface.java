package Database;

import Istruttore.Istruttore;

import java.util.ArrayList;

public interface Dao_Istruttore_Interface {
    void createIstruttore(int id, String nome, String cognome, String codiceFiscale,boolean pt,int nAssistiti);
    void incrementaAssistiti(int id);
    void decrementaAssistiti(int id);
    int getMaxId();
    int getIdByNomeCognome(String nome,String cognome);
    void setPt(int id,boolean pt);
    ArrayList<Istruttore> getAllPT();
    void deleteIstruttore(int id);
    int getNumeroAssistiti(int id);
    boolean isPT(int id);

}
