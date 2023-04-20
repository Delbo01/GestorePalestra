package Istruttore;

import Cliente.Cliente;

public class PersonalTrainerMapper {
    private Cliente cliente;
    private Istruttore pt;

    public PersonalTrainerMapper(Cliente cliente, Istruttore pt) {
        this.cliente = cliente;
        this.pt = pt;
    }

    public Istruttore getPtMapper() {
        return pt;
    }

    public void setPtMapper(Istruttore pt) {
        this.pt = pt;
    }

    public Cliente getCliente() {
        return cliente;
    }
}
