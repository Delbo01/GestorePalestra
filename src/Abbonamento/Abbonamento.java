package Abbonamento;


import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;

public class Abbonamento {
    private final int durata;
    private final String nome;
    private final int prezzo;
    private GregorianCalendar dataInizio = new GregorianCalendar();
    private  GregorianCalendar dataFine;
    private boolean corsi;

    public Abbonamento(int durata, String nome, int prezzo,String dataInizio, boolean corsi) {
        this.durata = durata;
        this.nome = nome;
        this.prezzo = prezzo;
        SimpleDateFormat s1=new SimpleDateFormat("dd/MM/yyyy");
        try {
            this.dataInizio.setTime(s1.parse(dataInizio));
        } catch (Exception e) {
            e.printStackTrace();
        }
        GregorianCalendar date=new GregorianCalendar();
        date.add(this.dataInizio.get(GregorianCalendar.MONTH), durata);
        dataFine=date;
        this.corsi = corsi;
    }
    public Abbonamento(Abbonamento a){
        this.durata=a.getDurata();
        this.prezzo=a.getPrezzo();
        this.nome=a.getNome();
        this.dataFine=a.dataFine;
        this.dataInizio=a.dataInizio;
    }
    public void visualizzaAbbonamento(){
        System.out.println("Abbonamento "+nome+"con: ");
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

    public boolean isCorsi() {
        return corsi;
    }

    public String getDataInizio() {
        return dataInizio.get(GregorianCalendar.DATE)+"/"+(dataInizio.get(GregorianCalendar.MONTH)+1)+"/"+dataInizio.get(GregorianCalendar.YEAR);
    }

    public String getDataFine() {
        return dataFine.get(GregorianCalendar.DATE)+"/"+(dataFine.get(GregorianCalendar.MONTH)+1)+"/"+dataFine.get(GregorianCalendar.YEAR);
    }
}
