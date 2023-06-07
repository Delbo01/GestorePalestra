package Database;

import Allenamento.ProgrammaAllenamento;

public interface Dao_Programma_Interface {
    void creaProgramma(int idProg, int idScheda, int nrEsercizio, String durata);
    void eliminaProgramma(int id);
    ProgrammaAllenamento getProgramma(int id);
    int getMaxIdProgramma();
}
