package Cliente;

public class Generalita {
    private final String cf;
    private final String nome;
    private final String cognome;

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
