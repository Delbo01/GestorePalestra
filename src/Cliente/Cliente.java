package Cliente;

import Allenamento.Scheda;
import GestioneRichieste.GestoreRichiestaScheda;
import GestioneRichieste.Richiesta;
import IstruttoreCalendario.Calendario;
import IstruttoreCalendario.GestorePT;
import IstruttoreCalendario.Istruttore;

import java.util.Scanner;

public class Cliente {
    private Generalita generalità;
    private float altezza;
    private float peso;
    private Abbonamento abbonamento = null;
    private Scheda scheda = null;
    private GestoreRichiestaScheda gestoreRichiestaScheda;
    private GestorePT gestorePT;
    private Istruttore pt = null;
    private GestoreAbbonamenti gestoreAbbonamenti;
    private Calendario calendario;


    public Cliente(Generalita generalità, float altezza, float peso, GestoreRichiestaScheda gestoreRichiestaScheda, GestoreAbbonamenti gestoreAbbonamenti, GestorePT gestorePT,Calendario calendario){
        this.generalità = new Generalita(generalità);
        this.altezza = altezza;
        this.peso = peso;
        this.gestoreRichiestaScheda = gestoreRichiestaScheda;
        this.gestorePT = gestorePT;
        this.gestoreAbbonamenti = gestoreAbbonamenti;
        this.calendario = calendario;
    }

    public void setScheda(Scheda scheda) {
        this.scheda = scheda;
    }

    public void visualizzaScheda(Scanner sc) {
        if (scheda != null)
            scheda.visualizzaScheda(sc);
        else System.out.println("nessuna scheda da visualizzare");
    }

    public void vediAbbonamento() {
        if (abbonamento != null) {
            abbonamento.visualizzaAbbonamento();
        } else System.out.println("nessun abbonamneto da visualizzare");
    }

    public void richiediScheda(String obbiettivo, int nProg, String durataProg) {
        Richiesta richiesta = new Richiesta(obbiettivo, nProg, durataProg, this, pt);
        if (pt == null)
            gestoreRichiestaScheda.addRichiesta(richiesta);
        else pt.getGestoreRichiestaSchedaPT().addRichiesta(richiesta);
    }

    public void vediAbbonamneti() {
        gestoreAbbonamenti.vediAbbonamenti();
    }

    public void ottieniAbbonamento(int index, boolean corsi) {
        this.abbonamento = gestoreAbbonamenti.getAbbonamneto(index, corsi);
    }

    public void richiediPersonalTrainer() {
        Istruttore trainer = gestorePT.ottieniPT();
        if (trainer != null) {
            pt = trainer;
            System.out.println(pt.getGeneralita().getNome() + "\n");
        } else
            System.out.println("Nessun Allenatore disponibile al momento\n");
    }

    public void richiediPersonalTrainer(String allenatore) {
        Istruttore trainer = gestorePT.ottieniPT(allenatore);
        if (trainer != null)
            pt = trainer;
        else
            System.out.println("L'allenatore non ha disponibilità al momento\n");
    }

    public void rimuoviPersonalTrainer() {
        if (pt != null) {
            gestorePT.rimuoviAssistito(pt);
        } else
            System.out.println("Errore non è presente alcun personal trainer\n");
    }

    public void vediCorsiGiornalieri(int mese, int giorno){
        calendario.vediCorsiGiornalieri(mese,giorno);
    }

    public void vediCorsiMensili(int mese){
        calendario.vediCorsiMensili(mese);
    }
}
