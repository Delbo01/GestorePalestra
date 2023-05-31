package Allenamento;

public class Esercizio {
    private final String nome;
    private final int serie;
    private final int reps;
    private int carico=0;
    private final int tempoRecupero;
    private final String note;
    private final Timer timer;

    public Esercizio(String nome, int serie, int reps, int tempoRecupero, String note) {
        this.nome = nome;
        this.serie = serie;
        this.reps = reps;
        this.tempoRecupero = tempoRecupero;
        this.note = note;
        this.timer=new Timer(tempoRecupero);
    }

    public String getNome() {
        return nome;
    }

    public int getSerie() {
        return serie;
    }

    public int getReps() {
        return reps;
    }

    public int getCarico() {
        return carico;
    }

    public int getTempoRecupero() {
        return tempoRecupero;
    }

    public String getNote() {
        return note;
    }

    public void setCarico(int carico) {
        this.carico = carico;
    }

    public void startTimer() throws InterruptedException{
        Thread t= new Thread(timer);
        t.start();
        t.join();
        t.interrupt();
    }
}
