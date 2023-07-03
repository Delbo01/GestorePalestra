package Database;

import Cliente.*;
import GestioneRichieste.GestoreRichiestaScheda;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class Dao_Cliente_Test {
    static Cliente cliente= new Cliente(new Generalita("MTTMTT95D12D612U","Matteo","Mattei"),180,82,new GestoreRichiestaScheda());
    static Dao_Cliente dao_cliente= new Dao_Cliente();

    @Test
    public void createClinete(){
        int id=dao_cliente.getMaxId()+1;
        dao_cliente.createCliente(id,cliente.getGeneralita().getNome(),cliente.getGeneralita().getCognome(),cliente.getGeneralita().getCf(),cliente.getAltezza(),cliente.getPeso());
        assertEquals(dao_cliente.getMaxId(),dao_cliente.getIdByCf(cliente.getGeneralita().getCf()));
        dao_cliente.deleteCliente(id);
    }

    @Test
    public void getIdByCf(){
        int id=dao_cliente.getMaxId()+1;
        dao_cliente.createCliente(id,cliente.getGeneralita().getNome(),cliente.getGeneralita().getCognome(),cliente.getGeneralita().getCf(),cliente.getAltezza(),cliente.getPeso());
        assertEquals(id,dao_cliente.getIdByCf(cliente.getGeneralita().getCf()));
        dao_cliente.deleteCliente(id);
    }
    @Test
    public void deleteCliente(){
        int id=dao_cliente.getMaxId()+1;
        dao_cliente.createCliente(id,cliente.getGeneralita().getNome(),cliente.getGeneralita().getCognome(),cliente.getGeneralita().getCf(),cliente.getAltezza(),cliente.getPeso());
        dao_cliente.deleteCliente(id);
        assertEquals(-1,dao_cliente.getIdByCf(cliente.getGeneralita().getCf()));
    }
}
