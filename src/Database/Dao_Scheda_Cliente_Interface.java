package Database;

import Allenamento.SchedaMapper;

public interface Dao_Scheda_Cliente_Interface {
    public void createScheda_Cliente(int idC, int idS);
    public boolean checkScheda_Cliente(int idC);
    public SchedaMapper getScheda_Cliente(int idC);
    void updateScheda_Cliente(int idC, int idScheda);
}
