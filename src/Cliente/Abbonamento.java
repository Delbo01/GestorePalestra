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

}
