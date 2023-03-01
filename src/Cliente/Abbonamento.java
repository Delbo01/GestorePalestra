package Cliente;

import java.util.Date;

public class Abbonamento {
    private int durata;
    private String nome;
    private int prezzo;
    private String dataInizio;
    private String dataFine;
    private boolean corsi;

    public Abbonamento(int durata, String nome, int prezzo, String dataInizio, String dataFine, boolean corsi) {
        this.durata = durata;
        this.nome = nome;
        this.prezzo = prezzo;
        this.dataInizio = dataInizio;
        this.dataFine = dataFine;
        this.corsi = corsi;
    }
    public Abbonamento(Abbonamento a){
        this.durata=a.getDurata();
        this.prezzo=a.getPrezzo();
        this.nome=a.getNome();
    }
    public void visualizzaAbbonamento(){
        System.out.println("Abboamneto "+nome+"con: ");
        System.out.println("Data inizio: "+dataInizio);
        System.out.println("Data fine: "+dataFine);
        System.out.println("Prezzo: "+prezzo);
        System.out.println("Corsi: "+corsi);
    }

    public int getDurata() {
        return durata;
    }

    public String getNome() {
        return nome;
    }

    public int getPrezzo() {
        return prezzo;
    }

    public void setDataInizio(String dataInizio) {
        this.dataInizio = dataInizio;
    }

    public void setDataFine(String dataFine) {
        this.dataFine = dataFine;
    }

    public void setCorsi(boolean corsi) {
        this.corsi = corsi;
    }
}
