package Database;

import Allenamento.Scheda;

public interface Dao_Scheda_Interface {
    void createScheda(int idIstruttore,int idScheda,String obiettivo,int numeroProgrammi);

    Scheda getScheda(int id);
    int getMaxIdScheda();

}
