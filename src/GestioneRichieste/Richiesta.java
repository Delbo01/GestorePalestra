package GestioneRichieste;

import Cliente.Cliente;
import Istruttore.Istruttore;

public class Richiesta {
    private String obbiettivo;
    private int nProg;
    private String durataProg;
    private  Cliente cliente;
    private  Istruttore istruttore;

    public Richiesta(String obbiettivo, int nProg, String durataProg, Cliente cliente, Istruttore istruttore) {
        this.obbiettivo = obbiettivo;
        this.nProg = nProg;
        this.durataProg = durataProg;
        this.cliente = cliente;
        this.istruttore = istruttore;
    }
    public String getObbiettivo() {
        return obbiettivo;
    }
    public int getnProg() {
        return nProg;
    }
    public String getDurataProg() {
        return durataProg;
    }
    public Cliente getCliente() {
        return cliente;
    }
}
