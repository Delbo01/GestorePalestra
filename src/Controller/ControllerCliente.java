package Controller;

import Allenamento.Scheda;
import Cliente.Cliente;

public class ControllerCliente {
    Cliente cliente;

    public ControllerCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public void vediAbbonamenti(){
        cliente.vediAbbonamneti();
    }

    public void setScheda(Scheda scheda){

    }
}
