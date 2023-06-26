package Database;

import Abbonamento.Abbonamento;

public interface Dao_Abbonamento_Cliente_Interface {
    void creaAbbonamentoCliente(int idCliente, int idAbbonamento);
    void eliminaAbbonamentoCliente(int idCliente,int idAbbonamento);
    Abbonamento getAbbonamento(int idCliente);
}
