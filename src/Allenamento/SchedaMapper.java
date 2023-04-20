package Allenamento;

import Cliente.Cliente;

public class SchedaMapper {
    private Cliente cliente;
    private Scheda scheda;

    public SchedaMapper(Cliente cliente, Scheda scheda) {
        this.cliente = cliente;
        this.scheda = scheda;
    }

    public Scheda getScheda() {
        return scheda;
    }

    public void setSchedaMapper(Scheda scheda) {
        this.scheda = scheda;
    }

    public Cliente getCliente() {
        return cliente;
    }
}
