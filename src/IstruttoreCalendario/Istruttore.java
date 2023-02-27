package IstruttoreCalendario;

import Cliente.Generalita;
import GestoreLogin.CredenzialiIstruttore;

public class Istruttore {
    private Generalita generalita;
    private int numeroAssistiti = 0;
    private Calendario calendario;


    public Istruttore(Generalita gen,Calendario calendario){
        generalita = gen;
        this.calendario = calendario;
    }
    public Generalita getGeneralita() {
        return generalita;
    }
    public void inserisciCorso(int mese,int giorno,Corso corso){
        calendario.inserisciCorso(mese,giorno,corso);
    }
    public void rimuoviCorso(int mese,int giorno,Corso corso){
        calendario.rimuoviCorso(mese,giorno,corso);
    }
}
