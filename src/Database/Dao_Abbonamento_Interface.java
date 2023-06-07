package Database;

import Abbonamento.Abbonamento;

import java.util.ArrayList;

public interface Dao_Abbonamento_Interface{

    void creaAbbonamento(int id,int durata, String nome, int prezzo, boolean corsi,String dataInizio,String dataFine);
    void eliminaAbbonamento(int id);
    int getIdByNomeDurata(int durata, String nome);

    int getMaxId();
}
