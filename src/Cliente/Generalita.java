package Cliente;

public class Generalita {
    private String cf;
    private String nome;
    private String cognome;

    public Generalita(String cf, String nome, String cognome) {
        this.nome=nome;
        this.cognome=cognome;
        this.cf = cf;
    }

    public Generalita(Generalita g){
        this.nome=g.getNome();
        this.cognome=g.getCognome();
        this.cf=g.getCf();
    }

    public String getCf() {
        return cf;
    }

    public String getNome() {
        return nome;
    }

    public String getCognome() {
        return cognome;
    }
}
