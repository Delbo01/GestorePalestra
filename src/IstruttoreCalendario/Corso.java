package IstruttoreCalendario;

public class Corso {
    private String nome;
    private int postiDisponibili;
    private String orarioInizio;
    private String orarioFine;
    private Istruttore istruttore;
    private int numeroClientiPrenotati = 0;

    public Corso(String nome, int postiDisponibili, String orarioInizio, String orarioFine, Istruttore istruttore) {
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

    public Istruttore getIstruttore() {
        return istruttore;
    }

    public String getNome() {
        return nome;
    }
}
