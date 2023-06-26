package Database;

import Cliente.Generalita;
import Istruttore.Istruttore;
import org.junit.After;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class Dao_IstruttoreTest {

    static Dao_Istruttore dao_istruttore = new Dao_Istruttore();
    static Istruttore istruttore = new Istruttore(new Generalita("MTTMTT95D12D612U","Matteo","Mattei"));
    @Test
    public void createIstruttore() {
        dao_istruttore.createIstruttore(dao_istruttore.getMaxId()+1,istruttore.getGeneralita().getNome(),istruttore.getGeneralita().getCognome(),istruttore.getGeneralita().getCf(),false,0);
        assertEquals(dao_istruttore.getMaxId(),dao_istruttore.getIdByNomeCognome(istruttore.getGeneralita().getNome(),istruttore.getGeneralita().getCognome()));
    }

    @Test
    public void incrementaAssistiti() {
        dao_istruttore.createIstruttore(dao_istruttore.getMaxId()+1,istruttore.getGeneralita().getNome(),istruttore.getGeneralita().getCognome(),istruttore.getGeneralita().getCf(),false,0);
        dao_istruttore.incrementaAssistiti(dao_istruttore.getMaxId());
        assertEquals(1,dao_istruttore.getNumeroAssistiti(dao_istruttore.getMaxId()));
    }

    @Test
    public void decrementaAssistiti() {
        dao_istruttore.createIstruttore(dao_istruttore.getMaxId()+1,istruttore.getGeneralita().getNome(),istruttore.getGeneralita().getCognome(),istruttore.getGeneralita().getCf(),false,0);
        dao_istruttore.incrementaAssistiti(dao_istruttore.getMaxId());
        dao_istruttore.decrementaAssistiti(dao_istruttore.getMaxId());
        assertEquals(0,dao_istruttore.getNumeroAssistiti(dao_istruttore.getMaxId()));

    }

    @Test
    public void getIdByNomeCognome() {
        dao_istruttore.createIstruttore(dao_istruttore.getMaxId()+1,istruttore.getGeneralita().getNome(),istruttore.getGeneralita().getCognome(),istruttore.getGeneralita().getCf(),false,0);
        assertEquals(dao_istruttore.getMaxId(),dao_istruttore.getIdByNomeCognome(istruttore.getGeneralita().getNome(),istruttore.getGeneralita().getCognome()));
    }

    @Test
    public void setPt() {
        dao_istruttore.createIstruttore(dao_istruttore.getMaxId()+1,istruttore.getGeneralita().getNome(),istruttore.getGeneralita().getCognome(),istruttore.getGeneralita().getCf(),false,0);
        dao_istruttore.setPt(dao_istruttore.getMaxId(),true);
        assertTrue( dao_istruttore.isPT(dao_istruttore.getMaxId()));
        dao_istruttore.setPt(dao_istruttore.getMaxId(),false);
        assertFalse(dao_istruttore.isPT(dao_istruttore.getMaxId()));
    }


    @After
    public void tearDown(){
        dao_istruttore.deleteIstruttore(dao_istruttore.getMaxId());
    }
}