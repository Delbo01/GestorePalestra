package Allenamento;

public class Esercizio {
    private String nome;
    private int serie;
    private int reps;
    private float carico=0;
    private int tempoRecupero;
    private String note;
    private Timer timer;

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

    public float getCarico() {
        return carico;
    }

    public int getTempoRecupero() {
        return tempoRecupero;
    }

    public String getNote() {
        return note;
    }

    public void setCarico(float carico) {
        this.carico = carico;
    }
}
