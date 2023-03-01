package IstruttoreCalendario;

import Cliente.Generalita;
import GestioneRichieste.GestoreRichiestaScheda;
import GestoreLogin.CredenzialiIstruttore;

public class Istruttore {
    private Generalita generalita;
    private int numeroAssistiti = 0;
    private Calendario calendario;
    private GestoreRichiestaScheda gestoreRichiestaScheda;
    private GestoreRichiestaScheda gestoreRichiestaSchedaPT=null;


    public Istruttore(Generalita generalita, Calendario calendario, GestoreRichiestaScheda gestoreRichiestaScheda) {
        this.generalita = generalita;
        this.calendario = calendario;
        this.gestoreRichiestaScheda = gestoreRichiestaScheda;
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

    public GestoreRichiestaScheda getGestoreRichiestaSchedaPT() {
        return gestoreRichiestaSchedaPT;
    }
}
