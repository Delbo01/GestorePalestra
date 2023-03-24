package Cliente;

import Allenamento.Scheda;
import GestioneRichieste.GestoreRichiestaScheda;
import GestioneRichieste.Richiesta;
import Calendario.Calendario;
import Istruttore.GestorePT;
import Istruttore.Istruttore;

import java.util.Scanner;

public class Cliente {
    private final Generalita generalità;
    private final float altezza;
    private final float peso;
    private Abbonamento abbonamento = null;
    private Scheda scheda = null;
    private final GestoreRichiestaScheda gestoreRichiestaScheda;
    private final GestorePT gestorePT;
    private String pt = null;
    private final GestoreAbbonamenti gestoreAbbonamenti;
    private final Calendario calendario;


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
        if (checkAbbonamento()) {
            if (scheda != null)
                scheda.visualizzaScheda(sc);
            else System.out.println("nessuna scheda da visualizzare");
        }
    }

    public void vediAbbonamento() {
        if (abbonamento != null) {
            abbonamento.visualizzaAbbonamento();
        } else System.out.println("nessun abbonamneto da visualizzare");
    }

    public void richiediScheda(String obbiettivo, int nProg, String durataProg) {
        if (checkAbbonamento()){
            Richiesta richiesta = new Richiesta(obbiettivo, nProg, durataProg, this, gestorePT.getPtbyCF(pt));
            if (pt == null)
                gestoreRichiestaScheda.addRichiesta(richiesta);
            else {
                Istruttore i = gestorePT.getPtbyCF(pt);
                i.getGestoreRichiestaSchedaPT().addRichiesta(richiesta);
            }
        }
    }

    public void vediAbbonamneti() {
        gestoreAbbonamenti.vediAbbonamenti();
    }

    public void ottieniAbbonamento(int index, boolean corsi) {
        this.abbonamento = gestoreAbbonamenti.getAbbonamneto(index, corsi);
    }

    public void richiediPersonalTrainer() {
        if (checkAbbonamento()){
            Istruttore trainer = gestorePT.ottieniPT();
            if (trainer != null) {
                pt = trainer.getGeneralita().getCf();
                Istruttore i = gestorePT.getPtbyCF(pt);
                System.out.println(i.getGeneralita().getNome() + "\n");
            } else
                System.out.println("Nessun Allenatore disponibile al momento\n");
        }
    }

    public void richiediPersonalTrainer(String allenatore) {
        if (checkAbbonamento()){
            Istruttore trainer = gestorePT.ottieniPT(allenatore);
            if (trainer != null)
                pt = trainer.getGeneralita().getCf();
            else
                System.out.println("L'allenatore non ha disponibilità al momento\n");
        }
    }


    public void rimuoviPersonalTrainer() {
        if (checkAbbonamento()) {
            Istruttore i = gestorePT.getPtbyCF(pt);
            if (i != null) {
                gestorePT.rimuoviAssistito(i);
                pt = null;
            } else
                System.out.println("Errore non è presente alcun personal trainer\n");
        }
    }

    public void vediCorsiGiornalieri(int mese, int giorno){
        if (checkAbbonamento()) {
            calendario.vediCorsiGiornalieri(mese, giorno);
        }
    }

    public void vediCorsiMensili(int mese){
        if (checkAbbonamento()){
            calendario.vediCorsiMensili(mese);
        }
    }

    public Boolean prenotaCorso(int mese, int giorno,String corso){
        if (checkAbbonamento()){
            if (abbonamento.isCorsi()){
                return calendario.prenotaCorso(mese, giorno, corso);
            }
            else {
                System.out.println("Non hai un abbonamento con corsi");
                return false;
            }
        }
        System.out.println("Non hai un abbonamento");
        return false;
    }
    public void rimuoviPrenotazioneCorso(int mese,int giorno,String corso){
        if (checkAbbonamento()){
            if (abbonamento.isCorsi()){
                calendario.rimuoviPrenotazioneCorso(mese, giorno, corso);
            }
            else System.out.println("Non hai un abbonamento con corsi");
        }
    }
    public void vediCalendario(){
        if (checkAbbonamento()){
            calendario.vediCalendario();
        }
    }

    public String getPt() {
        return pt;
    }

    public boolean checkAbbonamento(){
        if(abbonamento!=null)
            return true;
        else{
            System.out.println("Non hai un abbonamento");
            return false;
        }
    }
}
