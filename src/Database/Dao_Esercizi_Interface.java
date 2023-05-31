package Database;

public interface Dao_Esercizi_Interface {
    void createEsercizio(int idEs, int idProgramma,String nome,int serie,int ripetizioni,int carico,int recupero,String note);
    void deleteEsercizio(int id);
    void updateCarico(int id,int carico);
    int getMaxIdEsercizio();
}
