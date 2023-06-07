package Cliente;

import GestioneRichieste.GestoreRichiestaScheda;
import GestioneRichieste.Richiesta;
import Calendario.Calendario;
import Istruttore.Istruttore;

public class Cliente {
    private final Generalita generalita;
    private final float altezza;
    private final float peso;
    private final GestoreRichiestaScheda gestoreRichiestaScheda;
    private Calendario calendario;


    public Cliente(Generalita generalita, float altezza, float peso, GestoreRichiestaScheda gestoreRichiestaScheda, Calendario calendario) {
        this.generalita = new Generalita(generalita);
        this.altezza = altezza;
        this.peso = peso;
        this.gestoreRichiestaScheda = gestoreRichiestaScheda;
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

    public Generalita getGeneralita() {
        return generalita;
    }

    public void setCalendario(Calendario calendario) {
        this.calendario = calendario;
    }
}
