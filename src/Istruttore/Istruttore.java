package Istruttore;

import Allenamento.Esercizio;
import Allenamento.ProgrammaAllenamento;
import Allenamento.Scheda;
import Allenamento.SchedaMapper;
import Calendario.Calendario;
import Cliente.Generalita;
import GestioneRichieste.GestoreRichiestaScheda;
import GestioneRichieste.Richiesta;
import Calendario.Corso;

import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Istruttore {
    private final Generalita generalita;
    private int numeroAssistiti = 0;
    private final Calendario calendario;
    private GestoreRichiestaScheda gestoreRichiestaSchedaPT=null;

    final Pattern pattern = Pattern.compile("[0-9]+",Pattern.CASE_INSENSITIVE);


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

    public GestoreRichiestaScheda getGestoreRichiestaSchedaPT() {
        return gestoreRichiestaSchedaPT;
    }
}
