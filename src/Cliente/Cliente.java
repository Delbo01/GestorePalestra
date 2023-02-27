package Cliente;

import Allenamento.Scheda;

public class Cliente {
    private Generalita generalità;
    private float altezza;
    private float peso;
    private Abbonamento abbonamento= null;
    private Scheda scheda=null;

    public Cliente(Generalita generalità, float altezza, float peso) {
        this.generalità = new Generalita(generalità);
        this.altezza = altezza;
        this.peso = peso;
    }

    public void creaAbbonamento(int durata, String nome, int prezzo, String dataInizio, String dataFine, boolean corsi){
        this.abbonamento=new Abbonamento(durata,nome,prezzo,dataInizio,dataFine,corsi);
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
}
