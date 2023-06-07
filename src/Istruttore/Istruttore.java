package Istruttore;

import Calendario.Calendario;
import Cliente.Generalita;
import Calendario.Corso;
import GestioneRichieste.GestoreRichiestaScheda;

public class Istruttore {
    private final Generalita generalita;
    private int numeroAssistiti = 0;
    private Calendario calendario;

    private GestoreRichiestaScheda gestoreRichiestaSchedaPT=null;

    public Istruttore(Generalita gen,Calendario calendario){
        generalita = gen;
        this.calendario = calendario;
    }
    public Generalita getGeneralita() {
        return generalita;
    }
    public void inserisciCorso(int mese, int giorno, Corso corso){
        calendario.inserisciCorso(mese,giorno,corso);
    }
    public boolean rimuoviCorso(int mese,int giorno,String corso){
        if(calendario.rimuoviCorso(mese,giorno,corso)){
            System.out.println("Corso rimosso");
            return true;
        }
        return false;
    }
    public int getNumeroAssistiti() {
        return numeroAssistiti;
    }
    void incrementaAssistiti(){
        numeroAssistiti++;
    }
    void rimuoviAssistito(){
        numeroAssistiti--;
    }
    public void diventaPT(){
        gestoreRichiestaSchedaPT=new GestoreRichiestaScheda();
    }

    public GestoreRichiestaScheda getGestoreRichiestaSchedaPT() {
        return gestoreRichiestaSchedaPT;
    }

    public void setCalendario(Calendario calendario) {
        this.calendario = calendario;
    }

    public void setNumeroAssistiti(int numeroAssistiti) {
        this.numeroAssistiti = numeroAssistiti;
    }
}
