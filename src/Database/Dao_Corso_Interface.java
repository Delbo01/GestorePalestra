package Database;

public interface Dao_Corso_Interface {

    void createCorso(int id,String nome, int posti,String orarioInizio,String orarioFine,int idIstruttore,int numeroPrenotazioni,int mese,int giorno);
    void removeCorso(int id);
    void vediCorsiGiornalieri(int mese,int giorno);
    void addPrenotazione(int idCorso);
    public int getMaxId();
}
