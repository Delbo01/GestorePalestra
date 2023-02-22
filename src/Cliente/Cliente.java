package Cliente;

public class Cliente {
    private Generalita generalità;
    private float altezza;
    private float peso;
    private Abbonamento abbonamento= null;

    public Cliente(Generalita generalità, float altezza, float peso) {
        this.generalità = new Generalita(generalità);
        this.altezza = altezza;
        this.peso = peso;
    }

    public void creaAbbonamento(int durata, String nome, int prezzo, String dataInizio, String dataFine, boolean corsi){
        this.abbonamento=new Abbonamento(durata,nome,prezzo,dataInizio,dataFine,corsi);
    }
}
