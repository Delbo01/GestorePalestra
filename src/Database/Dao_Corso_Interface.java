package Database;

import Calendario.Corso;

import java.util.ArrayList;

public interface Dao_Corso_Interface {

    void createCorso(int id,String nome, int posti,String orarioInizio,String orarioFine,int idIstruttore,int numeroPrenotazioni,int mese,int giorno);
    void removeCorso(int id);
    ArrayList<Corso> vediCorsiGiornalieri(int mese, int giorno);
    ArrayList<Corso> vediCorsiMensili(int mese);
    void addPrenotazione(int idCorso);
    void deletePrenotazione(int idCorso);

    int getNumeroPrenotazioni(int idCorso);
    public int getMaxId();

    public int getIdByNome(String nome, int mese, int giorno);
}
