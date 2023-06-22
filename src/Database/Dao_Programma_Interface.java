package Database;

import Allenamento.ProgrammaAllenamento;

import java.util.ArrayList;

public interface Dao_Programma_Interface {
    void creaProgramma(int idProg, int idScheda, int nrEsercizio, String durata);
    void deleteProgramma(int id);
    ProgrammaAllenamento getProgramma(int id);
    int getMaxIdProgramma();
    public ArrayList<Integer> getIdbyIdScheda(int idScheda);
}
