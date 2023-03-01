package IstruttoreCalendario;

import Cliente.Generalita;
import GestioneRichieste.GestoreRichiestaScheda;

public class Istruttore {
    private Generalita generalita;
    private int numeroAssistiti = 0;
    private Calendario calendario;
    private GestorePT gestorePT;
    private GestoreRichiestaScheda gestoreRichiestaScheda;
    private GestoreRichiestaScheda gestoreRichiestaSchedaPT=null;


    public Istruttore(Generalita gen,Calendario calendario,GestorePT gestore){
        generalita = gen;
        this.calendario = calendario;
        gestorePT = gestore;
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
    public int getNumeroAssistiti() {
        return numeroAssistiti;
    }
    public void diventaPT(){
        gestorePT.inserisciPT(this);
        gestoreRichiestaSchedaPT=new GestoreRichiestaScheda();
    }
    void incrementaAssistiti(){
        numeroAssistiti++;
    }
    void rimuoviAssistito(){
        numeroAssistiti--;
    }

    public GestoreRichiestaScheda getGestoreRichiestaSchedaPT() {
        return gestoreRichiestaSchedaPT;
    }
}
