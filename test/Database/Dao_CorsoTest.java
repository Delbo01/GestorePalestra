package Database;

import Corso.Corso;
import org.junit.After;
import org.junit.Test;

import static org.junit.Assert.*;

public class Dao_CorsoTest {

    static Dao_Corso dao_corso = new Dao_Corso();
    static Dao_Istruttore dao_istruttore = new Dao_Istruttore();
    static Corso co = new Corso("prova", 2, "10", "12", "luca","rossi",0);
    @Test
    public void createCorso() {
        dao_istruttore.createIstruttore(dao_istruttore.getMaxId()+1,"luca","rossi","LCR",true,10);
        dao_corso.createCorso(dao_corso.getMaxId()+1,"prova",2,"10","12",dao_istruttore.getMaxId(),0,10,10);
        assertEquals("prova",dao_corso.vediCorsiMensili(10).get(0).getNome());
    }

    @Test
    public void removeCorso() {
        dao_corso.createCorso(dao_corso.getMaxId()+1,"prova",2,"10","12",dao_istruttore.getMaxId(),0,10,10);
        dao_corso.removeCorso(dao_corso.getMaxId());
        assertEquals(0,dao_corso.vediCorsiMensili(10).size());
        dao_corso.createCorso(1,"prova",2,"10","12",dao_istruttore.getMaxId(),0,10,10); //inserito per via del teardown

    }

    @Test
    public void addPrenotazione() {
        dao_corso.createCorso(dao_corso.getMaxId()+1,"prova",2,"10","12",dao_istruttore.getMaxId(),0,10,10);
        dao_corso.addPrenotazione(dao_corso.getMaxId());
        assertEquals(1,dao_corso.getNumeroPrenotazioni(dao_corso.getMaxId()));
    }

    @Test
    public void deletePrenotazione() {
        dao_corso.createCorso(dao_corso.getMaxId()+1,"prova",2,"10","12",dao_istruttore.getMaxId(),0,10,10);
        dao_corso.addPrenotazione(dao_corso.getMaxId());
        dao_corso.deletePrenotazione(dao_corso.getMaxId());
        assertEquals(0,dao_corso.vediCorsiMensili(10).get(0).getNumeroPrenotazioni());
    }

    @Test
    public void getIdByNome() {
        dao_corso.createCorso(dao_corso.getMaxId()+1,"prova",2,"10","12",dao_istruttore.getMaxId(),0,10,10);
        assertEquals(1,dao_corso.getIdByNome("prova",10,10));
    }

    @After
    public void tearDown(){
        dao_corso.removeCorso(dao_corso.getMaxId());

    }
}