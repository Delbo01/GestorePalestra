package Database;

import Calendario.Corso;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class Dao_Corso_Test {
    static Corso corso= new Corso("prova",1,"10","11","carlo","rossi");
    static Dao_Corso dao_corso= new Dao_Corso();

    @Test
    public void createCorso(){
        dao_corso.createCorso(dao_corso.getMaxId()+1, "prova",1,"10","11",3,0,1,1);
        assertEquals(dao_corso.getMaxId(), dao_corso.getIdByNome("prova",1,1));
        dao_corso.removeCorso(dao_corso.getIdByNome("prova",1,1));
    }
    @Test
    public void removeCorso(){
        dao_corso.createCorso(dao_corso.getMaxId()+1, "prova",1,"10","11",3,0,1,1);
        assertEquals(dao_corso.getMaxId(), dao_corso.getIdByNome("prova",1,1));
        dao_corso.removeCorso(dao_corso.getIdByNome("prova",1,1));
        assertEquals(-1, dao_corso.getIdByNome("prova",1,1));
    }
    @Test
    public void addPrenotazione(){
        int id=dao_corso.getMaxId()+1;
        dao_corso.createCorso(id, "prova",1,"10","11",3,0,1,1);
        dao_corso.addPrenotazione(id);
        assertEquals(1, dao_corso.getNumeroPrenotazioni(id));
        dao_corso.deletePrenotazione(id);
        assertEquals(0, dao_corso.getNumeroPrenotazioni(id));
        dao_corso.removeCorso(id);
    }
    @Test
    public void deletePrenotazione(){
        int id=dao_corso.getMaxId()+1;
        dao_corso.createCorso(id, "prova",1,"10","11",3,0,1,1);
        dao_corso.addPrenotazione(id);
        dao_corso.deletePrenotazione(id);
        assertEquals(0, dao_corso.getNumeroPrenotazioni(id));
        dao_corso.removeCorso(id);
    }
    @Test
    public void getNumeroPrenotazioni(){
        int id=dao_corso.getMaxId()+1;
        dao_corso.createCorso(id, "prova",10,"10","11",3,0,1,1);
        dao_corso.addPrenotazione(id);
        dao_corso.addPrenotazione(id);
        dao_corso.addPrenotazione(id);
        assertEquals(3, dao_corso.getNumeroPrenotazioni(id));
        dao_corso.deletePrenotazione(id);
        assertEquals(2, dao_corso.getNumeroPrenotazioni(id));
        dao_corso.removeCorso(id);
    }
    @Test
    public void vediCorsiMensili(){
        int id=dao_corso.getMaxId()+1;
        dao_corso.createCorso(id ,"prova",1,"10","11",3,0,1,1);
        int id2=dao_corso.getMaxId()+1;
        dao_corso.createCorso(id2, "prova",1,"10","11",3,0,1,13);
        int id3=dao_corso.getMaxId()+1;
        dao_corso.createCorso(id3, "prova",1,"10","11",3,0,1,18);
        ArrayList<Corso>corsi=dao_corso.vediCorsiMensili(1);
        assertEquals(3, corsi.size());
        for (Corso c:corsi){
            assertEquals("prova", c.getNome());
            assertEquals("10", c.getOrarioInizio());
            assertEquals("11", c.getOrarioFine());
            assertEquals(0, c.getNumeroClientiPrenotati());
        }
        dao_corso.removeCorso(id);
        dao_corso.removeCorso(id2);
        dao_corso.removeCorso(id3);
    }
}
