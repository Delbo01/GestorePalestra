package Cliente;

import java.util.Date;
import java.util.GregorianCalendar;

public class Abbonamento {
    private int durata;
    private String nome;
    private int prezzo;
    private GregorianCalendar dataInizio=new GregorianCalendar();
    private GregorianCalendar dataFine;
    private boolean corsi;

    public Abbonamento(int durata, String nome, int prezzo, boolean corsi) {
        this.durata = durata;
        this.nome = nome;
        this.prezzo = prezzo;
        GregorianCalendar date=new GregorianCalendar();
        date.add(dataInizio.get(GregorianCalendar.MONTH), durata);
        dataFine=date;
        this.corsi = corsi;
    }
    public Abbonamento(Abbonamento a){
        this.durata=a.getDurata();
        this.prezzo=a.getPrezzo();
        this.nome=a.getNome();
    }
    public void visualizzaAbbonamento(){
        System.out.println("Abboamneto "+nome+"con: ");
        System.out.println("Data inizio: "+dataInizio.get(GregorianCalendar.DATE)+"/"+(dataInizio.get(GregorianCalendar.MONTH)+1)+"/"+dataInizio.get(GregorianCalendar.YEAR));
        System.out.println("Data fine: "+dataFine.get(GregorianCalendar.DATE)+"/"+(dataFine.get(GregorianCalendar.MONTH)+1)+"/"+dataFine.get(GregorianCalendar.YEAR));
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
    public void setCorsi(boolean corsi) {
        this.corsi = corsi;
    }
}
