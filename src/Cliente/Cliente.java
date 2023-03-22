package Cliente;

import Allenamento.Scheda;
import GestioneRichieste.GestoreRichiestaScheda;
import GestioneRichieste.Richiesta;
import Calendario.Calendario;
import Istruttore.GestorePT;
import Istruttore.Istruttore;

import java.util.Scanner;

public class Cliente {
    private Generalita generalità;
    private float altezza;
    private float peso;
    private Abbonamento abbonamento = null;
    private Scheda scheda = null;
    private GestoreRichiestaScheda gestoreRichiestaScheda;
    private GestorePT gestorePT;
    private String pt = null;
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
        Richiesta richiesta = new Richiesta(obbiettivo, nProg, durataProg, this, gestorePT.getPtbyCF(pt));
        if (pt == null)
            gestoreRichiestaScheda.addRichiesta(richiesta);
        else{
            Istruttore i=gestorePT.getPtbyCF(pt);
            i.getGestoreRichiestaSchedaPT().addRichiesta(richiesta);
        }
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
            pt = trainer.getGeneralita().getCf();
            Istruttore i=gestorePT.getPtbyCF(pt);
            System.out.println(i.getGeneralita().getNome() + "\n");
        } else
            System.out.println("Nessun Allenatore disponibile al momento\n");
    }

    public void richiediPersonalTrainer(String allenatore) {
        Istruttore trainer = gestorePT.ottieniPT(allenatore);
        if (trainer != null)
            pt = trainer.getGeneralita().getCf();
        else
            System.out.println("L'allenatore non ha disponibilità al momento\n");
    }

    public void rimuoviPersonalTrainer() {
        Istruttore i=gestorePT.getPtbyCF(pt);
        if (i != null) {
            gestorePT.rimuoviAssistito(i);
        } else
            System.out.println("Errore non è presente alcun personal trainer\n");
    }

    public void vediCorsiGiornalieri(int mese, int giorno){
        calendario.vediCorsiGiornalieri(mese,giorno);
    }

    public void vediCorsiMensili(int mese){
        calendario.vediCorsiMensili(mese);
    }

    public void prenotaCorso(int mese, int giorno,String corso){
        calendario.prenotaCorso(mese,giorno,corso);
    }
    public void rimuoviPrenotazioneCorso(int mese,int giorno,String corso){
        calendario.rimuoviPrenotazioneCorso(mese,giorno,corso);
    }
    public void vediCalendario(){
        calendario.vediCalendario();
    }
}
