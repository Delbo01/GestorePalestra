package Cliente;

import Allenamento.Scheda;
import GestioneRichieste.GestoreRichiestaScheda;
import GestioneRichieste.Richiesta;
import IstruttoreCalendario.Istruttore;

public class Cliente {
    private Generalita generalità;
    private float altezza;
    private float peso;
    private Abbonamento abbonamento= null;
    private Scheda scheda=null;
    private GestoreRichiestaScheda gestoreRichiestaScheda;
    private Istruttore pt=null;
    private GestoreAbbonamenti gestoreAbbonamenti;

    public Cliente(Generalita generalità, float altezza, float peso, GestoreRichiestaScheda gestoreRichiestaScheda, GestoreAbbonamenti gestoreAbbonamenti) {
        this.generalità = new Generalita(generalità);
        this.altezza = altezza;
        this.peso = peso;
        this.gestoreRichiestaScheda= gestoreRichiestaScheda;
    }

    public void vediAbbonamneti(){
        gestoreAbbonamenti.vediAbbonamneti();
    }

    public void ottieniAbbonamento(int index, String dataInizio, String dataFine, boolean corsi){
        this.abbonamento=gestoreAbbonamenti.ottieniAbbonamneto(index,dataInizio,dataFine,corsi);
    }

    public void setScheda(Scheda scheda) {
        this.scheda = scheda;
    }
    public void visualizzaScheda(){
        if (scheda!=null)
            scheda.visualizzaScheda();
        else System.out.println("nessuna scheda da visualizzare");
    }
    public void vediAbbonamento(){
        if (abbonamento!= null){
            abbonamento.visualizzaAbbonamento();
        }else System.out.println("nessun abbonamneto da visualizzare");
    }

    public void richiediScheda(String obbiettivo,int nProg, String durataProg ){
        Richiesta richiesta= new Richiesta(obbiettivo,nProg,durataProg,this,pt);
        if (pt==null)
            gestoreRichiestaScheda.addRichiesta(richiesta);
        else pt.getGestoreRichiestaSchedaPT().addRichiesta(richiesta);
    }
}
