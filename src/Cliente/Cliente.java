package Cliente;

import GestioneRichieste.GestoreRichiestaScheda;
import GestioneRichieste.Richiesta;
import Controller.Calendario;
import Istruttore.Istruttore;

public class Cliente {
    private final Generalita generalita;
    private final float altezza;
    private final float peso;
    private  GestoreRichiestaScheda gestoreRichiestaScheda;

    public Cliente(Generalita generalita, float altezza, float peso, GestoreRichiestaScheda gestoreRichiestaScheda) {
        this.generalita = new Generalita(generalita);
        this.altezza = altezza;
        this.peso = peso;
        this.gestoreRichiestaScheda = gestoreRichiestaScheda;
    }

    public void richiediScheda(String obbiettivo, int nProg, String durataProg, Istruttore pt) {
        Richiesta richiesta = new Richiesta(obbiettivo, nProg, durataProg, this, pt);
        if (pt == null)
            gestoreRichiestaScheda.addRichiesta(richiesta);
        else {
            pt.getGestoreRichiestaSchedaPT().addRichiesta(richiesta);
        }
    }
    public Generalita getGeneralita() {
        return generalita;
    }

    public void setGestoreRichiestaScheda(GestoreRichiestaScheda gestoreRichiestaScheda) {
        this.gestoreRichiestaScheda = gestoreRichiestaScheda;
    }

    public float getAltezza() {
        return altezza;
    }

    public float getPeso() {
        return peso;
    }
}
