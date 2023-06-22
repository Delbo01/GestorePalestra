package Database;

import Allenamento.Scheda;

public interface Dao_Scheda_Interface {
    void createScheda(int idIstruttore,int idScheda,String obiettivo,int numeroProgrammi);
    void deleteScheda(int id);
    Scheda getScheda(int id);
    int getMaxIdScheda();

}
