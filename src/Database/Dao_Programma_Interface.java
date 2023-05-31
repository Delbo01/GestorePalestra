package Database;

public interface Dao_Programma_Interface {
    void creaProgramma(int idProg, int idScheda, int nrEsercizio, String durata);
    void eliminaProgramma(int id);

    int getMaxIdProgramma();
}
