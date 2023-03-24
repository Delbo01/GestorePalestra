package Calendario;

public class Corso {
    private final String nome;
    private final int postiDisponibili;
    private final String orarioInizio;
    private final String orarioFine;
    private final String istruttore;
    private int numeroClientiPrenotati = 0;

    public Corso(String nome, int postiDisponibili, String orarioInizio, String orarioFine, String istruttore) {
        this.nome = nome;
        this.postiDisponibili = postiDisponibili;
        this.orarioInizio = orarioInizio;
        this.orarioFine = orarioFine;
        this.istruttore = istruttore;
    }

    Boolean prenota(){
        if(numeroClientiPrenotati < postiDisponibili){
            numeroClientiPrenotati++;
            return true;
        }
        System.out.println("Spiacente numero di posti esauriti");
        return false;
    }

    Boolean rimuoviPrenotazione(){
        if(numeroClientiPrenotati == 0){
            return false;
        }
        numeroClientiPrenotati--;
        return true;

    }

    public String getOrarioInizio() {
        return orarioInizio;
    }

    public String getOrarioFine() {
        return orarioFine;
    }

    public String getIstruttore() {
        return istruttore;
    }

    public String getNome() {
        return nome;
    }

    public int getNumeroPrenotazioni() {
        return numeroClientiPrenotati;
    }
}
