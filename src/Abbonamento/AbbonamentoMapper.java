package Abbonamento;

import Cliente.Cliente;

public class AbbonamentoMapper {
    private Cliente cliente;
    private Abbonamento abbonamento;

    public AbbonamentoMapper(Cliente cliente, Abbonamento abbonamento) {
        this.cliente = cliente;
        this.abbonamento = abbonamento;
    }

    public Abbonamento getAbbonamento() {
        return abbonamento;
    }

    public void setAbbonamento(Abbonamento abbonamento) {
        this.abbonamento = abbonamento;
    }

    public Cliente getCliente() {
        return cliente;
    }
}
