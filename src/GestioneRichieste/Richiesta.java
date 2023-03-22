package GestioneRichieste;

import Cliente.Cliente;
import Istruttore.Istruttore;

public class Richiesta {
    private final String obbiettivo;
    private final int nProg;
    private final String durataProg;
    private  final Cliente cliente;
    private  final Istruttore istruttore;

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
