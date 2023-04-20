package Cliente;

import Abbonamento.Abbonamento;
import Abbonamento.GestoreAbbonamenti;
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
    //private Abbonamento abbonamento = null;
    //private Scheda scheda = null;
    private final GestoreRichiestaScheda gestoreRichiestaScheda;
    private final GestorePT gestorePT;
    //private String pt = null;
    private final GestoreAbbonamenti gestoreAbbonamenti;
    private final Calendario calendario;


    public Cliente(Generalita generalità, float altezza, float peso, GestoreRichiestaScheda gestoreRichiestaScheda, GestoreAbbonamenti gestoreAbbonamenti, GestorePT gestorePT, Calendario calendario) {
        this.generalità = new Generalita(generalità);
        this.altezza = altezza;
        this.peso = peso;
        this.gestoreRichiestaScheda = gestoreRichiestaScheda;
        this.gestorePT = gestorePT;
        this.gestoreAbbonamenti = gestoreAbbonamenti;
        this.calendario = calendario;
    }

    public void richiediScheda(String obbiettivo, int nProg, String durataProg, Istruttore pt) {
        Richiesta richiesta = new Richiesta(obbiettivo, nProg, durataProg, this, pt);
        if (pt == null)
            gestoreRichiestaScheda.addRichiesta(richiesta);
        else {
            pt.getGestoreRichiestaSchedaPT().addRichiesta(richiesta);
        }
    }

    public void vediAbbonamneti() {
        gestoreAbbonamenti.vediAbbonamenti();
    }
    public void vediCorsiGiornalieri(int mese, int giorno) {
        calendario.vediCorsiGiornalieri(mese, giorno);
    }

    public void vediCorsiMensili(int mese) {
        calendario.vediCorsiMensili(mese);
    }

    public Boolean prenotaCorso(int mese, int giorno, String corso) {
        return calendario.prenotaCorso(mese, giorno, corso);
    }

    public void rimuoviPrenotazioneCorso(int mese, int giorno, String corso) {
        calendario.rimuoviPrenotazioneCorso(mese, giorno, corso);
    }

    public void vediCalendario() {
        calendario.vediCalendario();
    }

    public Generalita getGeneralità() {
        return generalità;
    }
}
