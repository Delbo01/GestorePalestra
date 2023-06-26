package Istruttore;

import Controller.Calendario;
import Cliente.Generalita;
import Calendario.Corso;
import GestioneRichieste.GestoreRichiestaScheda;

public class Istruttore {
    private final Generalita generalita;
    private int numeroAssistiti = 0;

    private GestoreRichiestaScheda gestoreRichiestaSchedaPT=null;

    public Istruttore(Generalita gen){
        generalita = gen;
    }
    public Generalita getGeneralita() {
        return generalita;
    }
    public int getNumeroAssistiti() {
        return numeroAssistiti;
    }
    public void incrementaAssistiti(){
        numeroAssistiti++;
    }
    public void rimuoviAssistito(){
        numeroAssistiti--;
    }
    public void diventaPT(){
        gestoreRichiestaSchedaPT=new GestoreRichiestaScheda();
    }
    public GestoreRichiestaScheda getGestoreRichiestaSchedaPT() {
        return gestoreRichiestaSchedaPT;
    }
}
