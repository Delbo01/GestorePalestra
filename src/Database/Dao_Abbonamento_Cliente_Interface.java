package Database;

import Abbonamento.Abbonamento;

public interface Dao_Abbonamento_Cliente_Interface {
    void creaAbbonamentoCliente(int idCliente, int idAbbonamento);
    public void eliminaAbbonamentoCliente(int idCliente,int idAbbonamento);
}
