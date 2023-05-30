package Database;

import Abbonamento.Abbonamento;

import java.util.ArrayList;

public interface Dao_Abbonamento_Interface{

    public void creaAbbonamento(int durata, String nome, int prezzo, boolean corsi,String dataInizio,String dataFine);
    public void eliminaAbbonamento(int id);
    public int getIdByNomeDurata(int durata, String nome);


}
