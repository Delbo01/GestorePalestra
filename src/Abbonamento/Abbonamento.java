package Abbonamento;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class Abbonamento {
    private final int durata;
    private final String nome;
    private final int prezzo;
    private String dataInizio;
    private String dataFine;
    private boolean corsi;

    public Abbonamento(int durata, String nome, int prezzo, String dataInizio, boolean corsi) {
        this.durata = durata;
        this.nome = nome;
        this.prezzo = prezzo;
        this.corsi = corsi;
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");

        try {
            Calendar cal = Calendar.getInstance();
            cal.setTime(formatter.parse(dataInizio));

            cal.add(Calendar.MONTH, durata);

            String dataFine = formatter.format(cal.getTime());
            this.dataFine = dataFine;
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
        this.dataInizio = dataInizio;
    }

    public Abbonamento(Abbonamento a) {
        this.durata = a.getDurata();
        this.prezzo = a.getPrezzo();
        this.nome = a.getNome();
        this.dataFine = a.dataFine;
        this.dataInizio = a.dataInizio;
    }

    public void visualizzaAbbonamento() {
        System.out.println("Abbonamento " + nome + " con: ");
        System.out.println("Data inizio: " + dataInizio);
        System.out.println("Data fine: " + dataFine);
        System.out.println("Prezzo: " + prezzo);
        System.out.println("Corsi: " + corsi);
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

    public void setCorsi(boolean corsi) {
        this.corsi = corsi;
    }

    public boolean isCorsi() {
        return corsi;
    }

    public String getDataInizio() {
        return dataInizio;
    }

    public String getDataFine() {
        return dataFine;
    }
}
