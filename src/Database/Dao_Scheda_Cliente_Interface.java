package Database;

import Allenamento.SchedaMapper;

public interface Dao_Scheda_Cliente_Interface {
    void createScheda_Cliente(int idC, int idS);
    boolean checkScheda_Cliente(int idC);
    SchedaMapper getScheda_Cliente(int idC);
    void updateScheda_Cliente(int idC, int idScheda);
}
