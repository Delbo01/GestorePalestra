package Calendario;

public class Corso {
    private final String nome;
    private final int postiDisponibili;
    private final String orarioInizio;
    private final String orarioFine;
    private final String nomeIstruttore;
    private final String cognomeIstruttore;
    private int numeroClientiPrenotati = 0;

    public Corso(String nome, int postiDisponibili, String orarioInizio, String orarioFine, String nomeIstruttore, String cognomeIstruttore) {
        this.nome = nome;
        this.postiDisponibili = postiDisponibili;
        this.orarioInizio = orarioInizio;
        this.orarioFine = orarioFine;
        this.nomeIstruttore = nomeIstruttore;
        this.cognomeIstruttore = cognomeIstruttore;
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

    public String getNomeIstruttore() {
        return nomeIstruttore;
    }

    public String getCognomeIstruttore() {
        return cognomeIstruttore;
    }

    public String getNome(

    ) {
        return nome;
    }

    public int getNumeroPrenotazioni() {
        return numeroClientiPrenotati;
    }

    public int getPostiDisponibili() {
        return postiDisponibili;
    }

    public int getNumeroClientiPrenotati() {
        return numeroClientiPrenotati;
    }
}
