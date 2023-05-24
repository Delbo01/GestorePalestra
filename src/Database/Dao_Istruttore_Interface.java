package Database;

public interface Dao_Istruttore_Interface {
    public void createIstruttore(int id, String nome, String cognome, String codiceFiscale,boolean pt,int nAssistiti);
    public void updatePt(int id,boolean pt);
    public void incrementaAssistiti(int id);
    public void decrementaAssistiti(int id);
    public int getMaxId();
}
